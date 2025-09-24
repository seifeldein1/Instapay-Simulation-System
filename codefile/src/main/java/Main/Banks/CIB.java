package Main.Banks;

public class CIB implements IBank{
    private double balance = 10000.0 ;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double amount) {
        balance = amount;
    }

    public String verify(String phoneNumber) {
        return "verified successfully";
    }

}
