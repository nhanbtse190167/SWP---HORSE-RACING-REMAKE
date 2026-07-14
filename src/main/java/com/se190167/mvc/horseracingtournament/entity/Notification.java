package com.se190167.mvc.horseracingtournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_user_id")
    private User receiverUser;

    @Column(length = 255)
    private String title;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String content;

    @Column(name = "message_type", length = 50)
    private String messageType;

    @Column(name = "is_read")
    private Boolean isRead = false;

    // Getters
    public Integer getId() { return id; }
    public User getReceiverUser() { return receiverUser; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getMessageType() { return messageType; }
    public Boolean getIsRead() { return isRead; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setReceiverUser(User receiverUser) { this.receiverUser = receiverUser; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setMessageType(String messageType) { this.messageType = messageType; }
    public void setIsRead(Boolean isRead) { this.isRead = isRead; }
}