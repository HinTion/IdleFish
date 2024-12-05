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
import java.sql.SQLException;
import com.google.gson.Gson;
import Model.MessageChatData;
import Repository.DBConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet("/message/messagePost")
public class MessagePostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        MessageChatData messageChat = gson.fromJson(req.getReader(), MessageChatData.class);

        String sql = "INSERT INTO messageChat (senderID, receiverID, messageContent, messageContentPhoto, messageContentVoice, messageTime) VALUES (?, ?, ?, ?, ?, ?)";

        if (messageChat.getMessageContent() == null || messageChat.getMessageContent().isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Message content is required");
            return;
        }

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, messageChat.getSenderID());
            pstmt.setInt(2, messageChat.getReceiverID());
            pstmt.setString(3, messageChat.getMessageContent());
            pstmt.setString(4, messageChat.getMessageContentPhoto());
            pstmt.setString(5, messageChat.getMessageContentVoice());
            pstmt.setString(6, getCurrentTime());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                resp.setStatus(HttpServletResponse.SC_CREATED);
                PrintWriter out = resp.getWriter();
                out.print("Message inserted successfully");
                out.flush();
            } else {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to insert message");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return dateFormat.format(new Date());
    }
}