package library;

public class User {

    private int userId;
    private String userName;
    private String password;
    private int noOfBooksBorrowed;

    public User(){}

    public User(int userId, String userName, String password, int noOfBooksBorrowed) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.noOfBooksBorrowed = noOfBooksBorrowed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNoOfBooksBorrowed() {
        return noOfBooksBorrowed;
    }

    public void setNoOfBooksBorrowed(int noOfBooksBorrowed) {
        this.noOfBooksBorrowed = noOfBooksBorrowed;
    }
}
