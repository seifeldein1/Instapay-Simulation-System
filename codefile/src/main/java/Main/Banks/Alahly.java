package Main.Banks;


public class Alahly implements IBank{

    private double balance = 10000  ;

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
