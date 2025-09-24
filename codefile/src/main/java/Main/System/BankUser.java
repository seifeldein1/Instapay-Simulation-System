package Main.System;
import Main.Banks.BankFactory;
import Main.Banks.IBank;
import Main.SystemDB.*;

import java.util.Scanner;


public class BankUser  extends User {
    private IBank linkedBank ;
    public BankUser(){
        super();
    }
   public BankUser(String username , String password){
       super(username, password);
   }
    public void setLinkedBank(IBank linkedBank) {
        this.linkedBank = linkedBank;
    }
    @Override
    public double getBalance(){
        return linkedBank.getBalance();
    }
    @Override
    public  void setBalance(double balance){
        this.linkedBank.setBalance(balance);
    };

    @Override
    public String signup(String ProviderName,String phoneNumber) {

        BankFactory bankFactory = new BankFactory();
        IBank choosenBank = bankFactory.createBank(ProviderName);
        choosenBank.verify(phoneNumber); /// (1)verify in the bank
        linkedBank = choosenBank ;  /// link the bank with the user

        int sentOTP = SystemController.GenerateOTP(phoneNumber);
        int RecievedOTP = 155456 ;

        Scanner input = new Scanner(System.in);
        if(sentOTP == RecievedOTP){ /// (2)verify in the System
            System.out.println("OTP "+RecievedOTP+" is received");

            System.out.println("Enter you username:");
            String username = input.nextLine();
            System.out.println("Enter your password:");
            String password = input.nextLine();
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
