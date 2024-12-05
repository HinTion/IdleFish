package Controller;

import Model.MessagePreviewData;
import Repository.DBConnection;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

@WebServlet("/message/messagePreviewGet")
public class MessagePreviewGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int senderID = Integer.parseInt(req.getParameter("senderID"));
        int receiverID = Integer.parseInt(req.getParameter("receiverID"));

        String sql = "SELECT senderID, receiverID, userName, userAvatar, messageContent, messageContentPhoto, messageLastTime, messageUnreadCount FROM messagePreview WHERE senderID = ? AND receiverID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, senderID);
            pstmt.setInt(2, receiverID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String userAvatarBase64 = null;
                if (rs.getBlob("userAvatar") != null) {
                    byte[] userAvatarBytes = rs.getBlob("userAvatar").getBytes(1, (int) rs.getBlob("userAvatar").length());
                    userAvatarBase64 = Base64.getEncoder().encodeToString(userAvatarBytes);
                }

                String messageContentPhotoBase64 = null;
                if (rs.getBlob("messageContentPhoto") != null) {
                    byte[] messageContentPhotoBytes = rs.getBlob("messageContentPhoto").getBytes(1, (int) rs.getBlob("messageContentPhoto").length());
                    messageContentPhotoBase64 = Base64.getEncoder().encodeToString(messageContentPhotoBytes);
                }

                MessagePreviewData messagePreview = new MessagePreviewData(
                        rs.getInt("senderID"),
                        rs.getInt("receiverID"),
                        rs.getString("userName"),
                        userAvatarBase64,
                        rs.getString("messageContent"),
                        messageContentPhotoBase64,
                        rs.getString("messageLastTime"),
                        rs.getInt("messageUnreadCount")
                );

                Gson gson = new Gson();
                String json = gson.toJson(messagePreview);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.print(json);
                out.flush();
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Message preview not found");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}