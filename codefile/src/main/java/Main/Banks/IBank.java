package Main.Banks;

public interface IBank {
   public String verify(String phoneNumber);
   public double getBalance();

   public void setBalance(double amount) ;

}
