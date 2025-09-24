package Main;
import Main.Banks.Alahly;
import Main.System.BankUser;
import Main.System.SystemController;
import Main.System.WalletUser;
import Main.SystemDB.UserDB;
import Main.WalletProviders.Vodafone;

import java.util.Scanner;



public class Main
{
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		/// user can sign up normally , but we add at least 2 users of different types for testing
		BankUser dummyBankUser = new BankUser("m" , "123");
		dummyBankUser.setLinkedBank(new Alahly());
		UserDB.UserDB.add(dummyBankUser) ;


		WalletUser dummyWalletUser = new WalletUser("z" , "123");
		dummyWalletUser.setLinkedwallet(new Vodafone());
		UserDB.UserDB.add(dummyWalletUser);

		////////////////// Call System controller for all user utilities
		SystemController controller = new SystemController() ;

		//////// Menu

		boolean ok=false;
		int choice;
		while (true) {
			if (!ok) {
				System.out.println("1.Signup");
				System.out.println("2.Login");
				System.out.println("3.Exit\n");
				 choice = input.nextInt();
				if (choice == 1) {
					controller.signup();
				} else if (choice == 2 ) {
					int cnt = 0;
					while (cnt < 4 && !ok) {
						System.out.println("Your UserName:");
						String username = input.next();
						System.out.println("Your Password:");
						String password = input.next();
						String valid = controller.signin(username, password);
						ok = true;
						if (valid.equals("you signed in successfully")) break;
						else System.out.println(valid);
						cnt++;
					}
				}else{
					break;
				}

			} else {

				System.out.println("Choose your service:");
				System.out.println("1.Transfer");
				System.out.println("2.Payment Bills");
				System.out.println("3.Acquire Balance");
				System.out.println("4.Logout");

				choice = input.nextInt();
				if (choice == 1) {
					System.out.println("1.Transfer Instapay");
					System.out.println("2.Transfer Bank");
					System.out.println("3.Transfer Wallet");
					System.out.println("4.Logout");
					choice = input.nextInt();
					if (choice == 1) {
						//	controller.InstapayTransfer();
						System.out.println("User Name of Receiver: ");
						String name = input.next();
						System.out.println("Enter The Amount: ");
						int amount = input.nextInt();
						controller.InstapayTransfer(name, amount);
					} else if (choice == 2) {
						//	controller.BankTransfer();
						System.out.println("Bank Code of Receiver: ");
						String bankcode = input.next();
						System.out.println("Enter The Amount: ");
						int amount = input.nextInt();
						controller.BankTransfer(bankcode, amount);
					} else if (choice == 3) {
						//	controller.WalletTransfer();
						System.out.println("Phone Number of Receiver: ");
						String PhoneNum = input.next();
						System.out.println("Enter The Amount: ");
						double amount = input.nextInt();
						controller.WalletTransfer(PhoneNum, amount);
					} else {
						break;
					}
				} else if (choice == 2) {
					System.out.println("1.Gas Payment");
					System.out.println("2.Water Payment");
					System.out.println("3.Electric Payment");
					System.out.println("4.Logout");
					choice = input.nextInt();
					System.out.println("Name of company: ");
					String CName = input.next();
					System.out.println("Enter The Subscriber number: ");
					String Num = input.next();
					if (choice == 1) {
						controller.GasBill(CName, Num);
					} else if (choice == 2) {
						controller.WaterBill(CName, Num);
					} else if (choice == 3) {
						controller.ElectricBills(CName, Num);
					} else {
						break;
					}
				} else if (choice == 3) {
					System.out.print("Your Balance is:");
					controller.getBalance();
					System.out.println();
				} else  if(choice==4){
					ok=false;
				}else{
					break;
				}
			}
		}
	}
}
