
public class FileName extends BorrowingBook {

	String information;

	public FileName() {
		super();
	}

	public FileName(String information) {
		super();
		this.information = information;
	}

	@Override
	public String toString() {
		return "FileName [information=" + information + ", accountNum=" + accountNum + ", numberOfBook=" + numberOfBook
				+ ", DD=" + DD + ", exist=" + exist + "]";
	}

}
