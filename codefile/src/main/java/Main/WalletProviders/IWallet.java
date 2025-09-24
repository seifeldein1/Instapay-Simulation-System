package Main.WalletProviders;

public interface IWallet {
    public String verify(String phoneNumber);
    public double getBalance();
    public void setBalance(double amount);
}
