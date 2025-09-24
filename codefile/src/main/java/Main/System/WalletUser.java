package Main.System;
import Main.Banks.BankFactory;
import Main.Banks.IBank;
import Main.SystemDB.UserDB;
import Main.WalletProviders.IWallet;
import Main.WalletProviders.WalletFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class WalletUser extends User{

    public IWallet Linkedwallet ;

  public WalletUser(){
      super();
  }
    public WalletUser(String username , String password){
        super(username, password);

    }

    public void setLinkedwallet(IWallet linkedwallet) {
        Linkedwallet = linkedwallet;
    }

    public IWallet getLinkedwallet() {
        return Linkedwallet;
    }
    @Override
    public double getBalance(){
        return Linkedwallet.getBalance();
    }
    @Override
    public void setBalance(double amount){
         Linkedwallet.setBalance(amount);
    }
    @Override
    public String signup(String ProviderName,String phoneNumber) {

        WalletFactory walletFactory = new WalletFactory();
        IWallet choosenWallet = walletFactory.createWallet(ProviderName);
        choosenWallet.verify(phoneNumber); /// (1)verify in the bank
        Linkedwallet = choosenWallet ;  /// link the bank with the user


        int sentOTP = SystemController.GenerateOTP(phoneNumber);
        int RecievedOTP = 155456 ;
        Scanner input = new Scanner(System.in);
        if(sentOTP == RecievedOTP){ /// (2)verify in the System
            System.out.println("OTP "+RecievedOTP+" is received");

            System.out.println("Enter you username:");
            String username = input.next();
            System.out.println("Enter your password:");
            String password = input.next();

            // parent setters
            this.setUsername(username);
            this.setPassword(password);

            if (UserDB.IsUnique(username)){
                UserDB.addToDatabase(this);
                return "Signed up Successfully";
            }
        }
        return "username is already signed up";
    }
}
