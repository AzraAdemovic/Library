
import java.io.Serializable;

public class Account implements Serializable {

	private int accountNum;
	private String nameOfCustomer;
	private int numberrowedb;
	private static int numberOfAccounts;

	public Account() {
		numberOfAccounts++;

	}

	public int getAccountNum() {
		return accountNum;
	}

	public Account(int accountNum, String nameOfCustomer, int numberrowedb) {
		this.setAccountNum(accountNum);
		this.setNameOfCustomer(nameOfCustomer);
		this.setNumberrowedb(numberrowedb);
		numberOfAccounts++;

	}

	public void issued() {
		setNumberrowedb(getNumberrowedb() + 1);
	}

	public void avaliable() {
		setNumberrowedb(getNumberrowedb() - 1);
	}

	@Override
	public String toString() {
		return "Account [\naccountNum:" + getAccountNum() + ", \nnameOfCustomer:" + getNameOfCustomer() + ", \nnumborrowedb:"
				+ getNumberrowedb() + "]";
	}

	public int getNumberrowedb() {
		return numberrowedb;
	}

	public void setNumberrowedb(int numberrowedb) {
		this.numberrowedb = numberrowedb;
	}

	public static int getnumberOfAccounts() {
		
		return numberOfAccounts;
	}

	public String getNameOfCustomer() {
		return nameOfCustomer;
	}

	public void setNameOfCustomer(String nameOfCustomer) {
		this.nameOfCustomer = nameOfCustomer;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

}

