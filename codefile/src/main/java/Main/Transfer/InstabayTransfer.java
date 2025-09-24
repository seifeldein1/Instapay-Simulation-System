package Main.Transfer;
import Main.System.SystemController;
import Main.System.User;
import Main.SystemDB.UserDB;

public class InstabayTransfer implements Transfer {

    private User signedInUser;
    private User receiverUser;


    public boolean transfer(double amount , String username) {

        this.signedInUser = SystemController.getCurrentUser() ;
        receiverUser = UserDB.FindUserbyUsername(username);

        if (signedInUser.getBalance() >= amount) {
            double A=signedInUser.getBalance() - amount;

            signedInUser.setBalance(A);
            receiverUser.setBalance(receiverUser.getBalance() + amount);
            return true;
        }
        else {
            return false;
        }

    }

}
