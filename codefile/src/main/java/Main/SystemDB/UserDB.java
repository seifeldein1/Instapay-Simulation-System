package Main.SystemDB;
import Main.System.User;

import java.util.ArrayList;

public class UserDB {
    public static ArrayList<User> UserDB = new ArrayList<>(1000) ;

    public ArrayList<User> getUserDB() {
        return UserDB;
    }

    public static void addToDatabase(User Newuser) {
        if(UserDB.size() < 1000)
           UserDB.add(Newuser);
    }
    public static boolean IsUnique(String username){
        for(var i : UserDB){
            if(username.equals(i.getUsername())){
                return false ;
            }
        }
        return true ;
    }

    public static User FindUserbyUsernameAndpassword(String username , String password){
        for(var user : UserDB){
            if(user.getUsername().equals(username)  &&  user.getPassword().equals(password)){
                return user ;
            }
        }
        return null;
    }

    public static User FindUserbyUsername(String RequiredUsername){
        for(var user : UserDB){
            String username = user.getUsername();
            if(username.equals(RequiredUsername)){
                return user ;
            }
        }
        return null;
    }


}
