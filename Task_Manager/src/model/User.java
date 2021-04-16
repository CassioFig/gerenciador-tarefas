package model;

/**
 *
 * @author Cássio Figueiredo
 */
public class User {
    private int id;
    private final String user, password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    public void saveUser() {
        
    }

    public int getId() {
        return id;
    }
    
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
    
}
