package Main.Transfer;

import Main.System.SystemController;
import Main.System.User;
import Main.SystemDB.UserDB;
import Main.WalletProviders.IWallet;
import Main.WalletProviders.WalletFactory;

public class WalletTransfer implements Transfer {

    private User signedInUser;
    IWallet Recieverwallet ;

    public boolean transfer(double amount , String walletname) {

        this.signedInUser = SystemController.getCurrentUser();
        WalletFactory factory = new WalletFactory();
        Recieverwallet = factory.createWallet(walletname);

        // fake verification of wallet api
        if ( signedInUser.getBalance() >= amount ) {
            signedInUser.setBalance(signedInUser.getBalance() - amount);
            Recieverwallet.setBalance(Recieverwallet.getBalance()+amount);
            return true;
        }else{
            return false;
        }

    }
}
