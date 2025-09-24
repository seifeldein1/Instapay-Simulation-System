package Main.Transfer;
import Main.Banks.BankFactory;
import Main.Banks.IBank;
import Main.System.SystemController;
import Main.System.User;
import Main.SystemDB.UserDB;

public class BankTransfer implements Transfer {

    private User signedInUser;
    private IBank RecievedBank ;

    public boolean transfer(double amount  , String BankCode) {

        this.signedInUser = SystemController.getCurrentUser() ;

        BankFactory bankFactory= new BankFactory();
        RecievedBank = bankFactory.createBank(BankCode);

        if (signedInUser.getBalance() >= amount) {
            signedInUser.setBalance(signedInUser.getBalance() - amount);
            RecievedBank.setBalance(RecievedBank.getBalance() + amount);
            return true;
        }else{
            return false;
        }

    }
}

