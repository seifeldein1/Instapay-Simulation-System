package Main.System;
import Main.BillTypes.*;
import Main.SystemDB.UserDB;
import Main.Transfer.BankTransfer;
import Main.Transfer.InstabayTransfer;
import Main.Transfer.Transfer;
import Main.Transfer.WalletTransfer;
import java.util.Scanner;


public class SystemController {

    /// its like session in Web
    private static User CurrentUser ;
    private static User Reciever ;
    static Scanner input = new Scanner(System.in);

    public static User getCurrentUser() {
        return CurrentUser;
    }

    /// for ex : bank , alahly , 12345678911
    public String signup() {
        System.out.println("Enter your type  *bank / wallet*");
        String type         =  input.nextLine();
        System.out.println("Enter your provider name *alahly / vodafone*");
        String ProviderName =  input.nextLine();
        System.out.println("Enter your phone number");
        String phoneNumber  =  input.nextLine();

        if (type.equals("bank")){
            User bankUser = new BankUser();
           return bankUser.signup(ProviderName , phoneNumber);
        }
           User walletUser = new WalletUser();
           return walletUser.signup(ProviderName , phoneNumber);

    }

    public static int GenerateOTP(String phoneNumber){
       return 155456;
    }


    public String signin( String username , String password){
        User Founduser = UserDB.FindUserbyUsernameAndpassword(username , password);
        if(Founduser != null){
            CurrentUser=Founduser;
            return "you signed in successfully";
        }
        return "invalid username or password, Enter again";
    }


public Transfer transferMethod ;

///a Transfer to Wallet using the mobile number Controller

    public String TransferToWallet( String walletprovierName,  double amount){
        transferMethod = new WalletTransfer();
        transferMethod.transfer(amount , walletprovierName);
        return "successfully paid";
    }

///b. Transfer to Another instapay account Controller

    public String InstapayTransfer( String username,
                                    double amount){
        transferMethod = new InstabayTransfer();
        transferMethod.transfer(amount , username);
        return "successfully paid";
    }
///c. Transfer to Another Bank account


    public String BankTransfer( String BankCode,
                                double amount){
        transferMethod = new BankTransfer();
        transferMethod.transfer(amount  , BankCode);
        return "successfully paid";
    }
///D.Transfer to Another Bank Wallet
    public String WalletTransfer( String PhoneNum,
                                double amount){
        transferMethod = new WalletTransfer();
        transferMethod.transfer(amount  , PhoneNum);
        return "successfully paid";
    }


///d. Pay bills Controller

    public String GasBill(  String BillName,String code){

        IFactoryBills bills = new FactoryGas();
        IGas gas =  ((FactoryGas)bills).CreateObj(BillName);
        double amount = gas.CalcBill(code);
        CurrentUser.setBalance(CurrentUser.getBalance()-amount);
        return "successfully paid";
    }



    public String WaterBill( String BillName,
                             String code){

        IFactoryBills bills = new FactoryWater();
        IWater gas =  ((FactoryWater)bills).CreateObj(BillName);
        double amount = gas.CalcBill(code);
        CurrentUser.setBalance(CurrentUser.getBalance()-amount);
        return "successfully paid";
    }



    public String ElectricBills(String BillName,
                                String code){

        IFactoryBills bills = new FactoryElectric();
        IElectric gas =  ((FactoryElectric)bills).CreateObj(BillName);
        double amount = gas.CalcBill(code);
        CurrentUser.setBalance(CurrentUser.getBalance()-amount);
        return "successfully paid";
    }
    //Acquire Balance
    public  void getBalance(){
        System.out.println( CurrentUser.getBalance());
    }

}


