package Controller;

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
import com.google.gson.Gson;
import Model.MessageChatData;
import Repository.DBConnection;

@WebServlet("/message/messageGet")
public class MessageGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int senderID = Integer.parseInt(req.getParameter("senderID"));
        int receiverID = Integer.parseInt(req.getParameter("receiverID"));

        String sql = "SELECT senderID, receiverID, messageContent, messageContentPhoto, messageContentVoice, messageTime FROM messageChat WHERE senderID = ? AND receiverID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, senderID);
            pstmt.setInt(2, receiverID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                MessageChatData messageChat = new MessageChatData(
                        rs.getInt("senderID"),
                        rs.getInt("receiverID"),
                        rs.getString("messageContent"),
                        rs.getString("messageContentPhoto"),
                        rs.getString("messageContentVoice"),
                        rs.getString("messageTime")
                );

                Gson gson = new Gson();
                String json = gson.toJson(messageChat);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.print(json);
                out.flush();
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Message not found");
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