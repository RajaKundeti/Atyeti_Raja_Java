package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class UserLog {

    private Timestamp timestamp;
    private String userId;
    private String action;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserLog userLog = (UserLog) o;
        return Objects.equals(userId, userLog.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }

    @Override
    public String toString() {
        return "UserLog{" +
                "timestamp=" + timestamp +
                ", userId='" + userId + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
