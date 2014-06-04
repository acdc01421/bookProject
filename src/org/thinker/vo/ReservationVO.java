package org.thinker.vo;

import java.sql.Date;

public class ReservationVO {
	private int rno;
	private String id;
	private int bno;
	private Date regDate;
	
	
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	@Override
	public String toString() {
		return "ReservationVO [rno=" + rno + ", id=" + id + ", bno=" + bno
				+ ", regDate=" + regDate + "]";
	}
	
	
	
	
}
