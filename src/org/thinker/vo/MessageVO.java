package org.thinker.vo;

public class MessageVO {
	private int mno;
	private String fromId;
	private String toId;
	private String msg;
	
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	@Override
	public String toString() {
		return "MessageVO [mno=" + mno + ", fromId=" + fromId + ", toId="
				+ toId + ", msg=" + msg + "]";
	}
	
	
	
	
	
}
