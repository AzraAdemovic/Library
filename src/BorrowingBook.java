
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BorrowingBook extends Library implements Serializable {
	
	int accountNum;
	int numberOfBook;
	Date DD;
	boolean exist;

	public BorrowingBook() {
		DD = new Date();
	}

	public BorrowingBook(int AccountNum, int numberOfBook) {
		this.accountNum = AccountNum;
		this.numberOfBook = numberOfBook;
		DD = new Date();

	}

	public void check() {
		boolean bookExist = false;
		boolean accountExist = false;
		int accountIndex = 0;
		int bookIndex = 0;
		int numberBorrowed = 3;

		for (int i = 0; i < AccountList.size(); i++) {
			if (AccountList.get(i).getAccountNum() == accountNum) {
				accountExist = true;
				accountIndex = i;
				numberBorrowed = AccountList.get(i).getNumberrowedb();

			}
		}

		for (int j = 0; j < BookList.size(); j++) {
			if (BookList.get(j).getNumberOfBook() == numberOfBook) {
				bookExist = true;
				bookIndex = j;
			}
		}
		if (bookExist && accountExist && numberBorrowed < 3) {
			if (BookList.get(bookIndex).issued)
				System.out.println("The book is already rented. Sorry.");
			else {
				System.out.println("The book is all yours.");
				BookList.get(bookIndex).issued = true;
				AccountList.get(accountIndex).issued();
				exist = true;
			}
		} else if (bookExist && accountExist && numberBorrowed >= 3) {
			System.out.println("You  have too much rented books, please return one.");
		} else if (bookExist && accountExist == false && numberBorrowed < 3) {
			System.out.println("You need to create account.");
		} else if (bookExist && accountExist == false && numberBorrowed > 3) {
			System.out.println("You need to create account.");
		} else if (bookExist == false && accountExist && numberBorrowed < 3) {
			System.out.println("The book is not in our system. ");
		} else if (bookExist == false && accountExist && numberBorrowed > 3) {
			System.out.println("The book is not in our system. ");
		} else {
			System.out.println("Your account and the book you selected does not exist..");
		}

	}

	public void returnBook() {
		boolean memberExist = false;
		boolean bookExist = false;
		int memberIndex = 0;
		int bookIndex = 0;
		boolean rented = false;

		for (int i = 0; i < AccountList.size(); i++) {
			if (AccountList.get(i).getAccountNum() == accountNum) {
				memberExist = true;
				memberIndex = i;

			}
		}
		for (int j = 0; j < BookList.size(); j++) {
			if (BookList.get(j).getNumberOfBook() == numberOfBook) {
				bookExist = true;
				bookIndex = j;
				if (BookList.get(j).issued)
					rented = true;
			}
		}

		if (bookExist && memberExist && rented) {
			AccountList.get(memberIndex).avaliable();
			BookList.get(bookIndex).issued = false;
			DD = new Date();
			System.out.println("The book has been returned.");
			exist = true;
		} else if (bookExist && memberExist && rented == false) {
			System.out.println("Error! You don't have that book.");
		} else if (bookExist = false && memberExist) {
			System.out.println("The book does not exist.");
		} else if (bookExist && memberExist == false) {
			System.out.println("Your account does not exist in our system.");
		} else {
			System.out.println("There is some kind of error.");
		}

	}

	@Override
	public String toString() {
		return "BorrowingBook [accountNum=" + accountNum + ", numberOfBook=" + numberOfBook + ", Day you borrowed book="
				+ DD + ", exist=" + exist + "]";
	}

}

