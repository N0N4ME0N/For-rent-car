package For_rent_the_car;

import java.io.Serializable;

public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int userId;
    private String username;
    private String email;
    private String password;
    
    public Users(int userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    // Getters
    public int getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    
    // Setters (ถ้าจำเป็น)
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
