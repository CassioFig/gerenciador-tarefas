package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cássio Figueiredo
 */
public class User {
    private int id;
    private final String user;
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    public void saveUser() {
        this.password = this.encryptPassword(this.password);
    }
    
    private String encryptPassword(String password) {
        
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = algorithm.digest(password.getBytes("UTF-8"));
            
            return toHex(messageDigest);
           
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private String toHex(byte[] password) {
        StringBuilder hexString = new StringBuilder();
        
        for (byte b : password) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        
        return hexString.toString();
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
