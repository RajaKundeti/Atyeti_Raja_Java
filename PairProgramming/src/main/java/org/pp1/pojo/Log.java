package org.pp1.pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Log {

    private Timestamp timestamp;
    private int userId;
    private String messageType;
    private String message;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return userId == log.userId && Objects.equals(timestamp, log.timestamp) && Objects.equals(messageType, log.messageType) && Objects.equals(message, log.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, userId, messageType, message);
    }
}
