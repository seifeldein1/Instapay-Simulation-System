package Main.System;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;


public abstract class User {

    private long userID ;
    private String username ;
    private String password ;
    private String phoneNumber ;
     public User(){}

     public User(String username, String password) {
        this.username = username;
        this.password = password;
     }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract String signup(String ProviderName, String phoneNumber);


    public abstract double getBalance();
    public abstract void setBalance(double amount);
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getUserID() {return userID;}

    public void setUserID(long userID) {this.userID = userID;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

}