package Main.WalletProviders;


public class Orange implements IWallet {
    double balance = 10000 ;
    String phoneNumber ;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String verify(String phoneNumber) {
        return "verified successfully";
    }
}
