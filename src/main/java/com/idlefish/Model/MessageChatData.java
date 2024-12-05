package com.idlefish.Model;

public class MessageChatData
{
    private int senderID;
    private int receiverID;
    private String messageContent;
    private String messageContentPhoto;
    private String messageContentVoice;
    private String messageTime;

    public MessageChatData(int senderID, int receiverID, String messageContent, String messageContentPhoto, String messageContentVoice, String messageTime) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.messageContent = messageContent;
        this.messageContentPhoto = messageContentPhoto;
        this.messageContentVoice = messageContentVoice;
        this.messageTime = messageTime;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageContentPhoto() {
        return messageContentPhoto;
    }

    public void setMessageContentPhoto(String messageContentPhoto) {
        this.messageContentPhoto = messageContentPhoto;
    }

    public String getMessageContentVoice() {
        return messageContentVoice;
    }

    public void setMessageContentVoice(String messageContentVoice) {
        this.messageContentVoice = messageContentVoice;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }
}