package com.idlefish.Model;

public class MessagePreviewData
{
    Integer senderID;
    Integer receiverID;
    String userName;
    String userAvatar;
    String messageContent;
    String messageContentPhoto;
    String messageLastTime;
    Integer messageUnreadCount;

    public MessagePreviewData(Integer senderID, Integer receiverID, String userName, String userAvatar, String messageContent, String messageContentPhoto, String messageLastTime, Integer messageUnreadCount)
    {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.userName = userName;
        this.userAvatar = userAvatar;
        this.messageContent = messageContent;
        this.messageContentPhoto = messageContentPhoto;
        this.messageLastTime = messageLastTime;
        this.messageUnreadCount = messageUnreadCount;
    }

    public Integer getSenderID()
    {
        return senderID;
    }

    public void setSenderID(Integer senderID)
    {
        this.senderID = senderID;
    }

    public Integer getReceiverID()
    {
        return receiverID;
    }

    public void setReceiverID(Integer receiverID)
    {
        this.receiverID = receiverID;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserAvatar()
    {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar)
    {
        this.userAvatar = userAvatar;
    }

    public String getMessageContent()
    {
        return messageContent;
    }

    public void setMessageContent(String messageContent)
    {
        this.messageContent = messageContent;
    }

    public String getMessageContentPhoto()
    {
        return messageContentPhoto;
    }

    public void setMessageContentPhoto(String messageContentPhoto)
    {
        this.messageContentPhoto = messageContentPhoto;
    }

    public String getMessageLastTime()
    {
        return messageLastTime;
    }

    public void setMessageLastTime(String messageLastTime)
    {
        this.messageLastTime = messageLastTime;
    }

    public Integer getMessageUnreadCount()
    {
        return messageUnreadCount;
    }

    public void setMessageUnreadCount(Integer messageUnreadCount)
    {
        this.messageUnreadCount = messageUnreadCount;
    }
}
