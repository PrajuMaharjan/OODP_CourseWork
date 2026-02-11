package quizapp;
public class User {
    private int userId;
    private String username;
    private boolean isAdmin;

    public User(int userId, String username, boolean isAdmin) {
        this.userId=userId;
        this.username=username;
        this.isAdmin=isAdmin;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public boolean getisAdmin() {
        return isAdmin;
    }

    public void setUserId(int userId) {
        this.userId=userId;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public void setAdmin(boolean admin) {
        isAdmin=admin;
    }

	}