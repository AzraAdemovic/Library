import java.util.ArrayList;
import java.util.Scanner;

public class Library {

	static ArrayList<Account> AccountList = new ArrayList<>();
	static ArrayList<Book> BookList = new ArrayList<>();
	static ArrayList<FileName> File = new ArrayList<>();
	static boolean running = true;

	public static void main(String[] args) {

		Scanner unos = new Scanner(System.in);
		System.out.println("Welcome to our library :) ");

		while (running) {
			System.out.print("please choose what you want :)"
		            + "\n" 
					+ "\n 0. => Create account.\n"
					+ "\n 1. => Create a book.\n"
					+ "\n 2. => Borrowing books. \n" 
					+ "\n 3. => Returning books.\n"
					+ "\n 4. => Information about existing accounts.\n ");
		
		
		int choice = unos.nextInt();
		switch (choice) {
		case 0:
			Account account = new Account();
			AccountList.add(account);
			System.out.println("Please insert your name :");
			unos.nextLine(); 
			String name = unos.nextLine();
			account.setNameOfCustomer(name);
			account.setAccountNum(Account.getnumberOfAccounts());
			System.out.println(
					name + "Your account is successfully created, your account number is  " + account.getAccountNum());
			break;
		case 1:
			Book book = new Book();
			BookList.add(book);
			System.out.println("Insert the title of book, please :");
			unos.nextLine();
			String titleOfBook = unos.nextLine();
			book.setTitle(titleOfBook);
			book.numberOfBook = Book.getNumberOfBook();
			System.out.println(
					"The book is successfully added into our library, number of book is :" + book.numberOfBook);
			break;
		case 2:
			BorrowingBook borrow = new BorrowingBook();
			System.out.println("Please insert your account number : ");
			unos.nextLine();
			int brojracuna = unos.nextInt();
			borrow.accountNum = brojracuna;
			System.out.println("I need number of book you wanna borrow :");
			unos.nextLine();
			int brojknjige = unos.nextInt();
			borrow.numberOfBook = brojknjige;
			borrow.check();
			if (borrow.exist) {
				FileName idk = new FileName();
				idk.accountNum = brojracuna;
				idk.numberOfBook = brojknjige;
				idk.information = "Rented";
				File.add(idk);
			}
			break;
		case 3:
			System.out.println("You wanna return borrowed book, please insert your account number: ");
			unos.nextLine();
			int OpetBrojracuna = unos.nextInt();
			boolean postojis = true;
			if (postojis) {
				System.out.println("Please insert number of book ");
				unos.nextLine();
				int opetbrKnjige = unos.nextInt();
				BorrowingBook returnB = new BorrowingBook(OpetBrojracuna, opetbrKnjige);
				returnB.returnBook();
				if (returnB.exist) {
					FileName idk2 = new FileName();
					idk2.accountNum = OpetBrojracuna;
					idk2.numberOfBook = opetbrKnjige;
					idk2.information = "Returned";
					File.add(idk2);

				}

			} else {
				System.out.println("You have wrong account number.");
			}
			break;
		case 4:
			for (int i = 0; i < AccountList.size(); i++) {
				System.out.println(AccountList.get(i).toString());
			}
			break;
		default:
			System.out.println("Please choose one of offered options.");
			break;
			
		

		}}
		unos.close();
		

	}

}
