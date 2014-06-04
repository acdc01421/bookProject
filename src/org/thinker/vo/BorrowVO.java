package org.thinker.vo;

import java.sql.Date;

public class BorrowVO extends BookVO{

	private int bwno;
	private int bno;
	private String id;
	private Date borrowDate;
	private Date returnDate;
	private Date dueDate;
	

	public int getBwno() {
		return bwno;
	}

	public void setBwno(int bwno) {
		this.bwno = bwno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	
	@Override
	public String toString() {
		return "BorrowVO [bwno=" + bwno + ", bno=" + bno + ", id=" + id
				+ ", borrowDate=" + borrowDate + ", returnDate=" + returnDate
				+ ", dueDate=" + dueDate + ", title=" + title + ", status="
				+ status + "]";
	}

}
