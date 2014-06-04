package org.thinker.vo;

public class Criteria {
	private String keyword;
	private int pageNumber;
	private String type;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Criteria [keyword=" + keyword + ", pageNumber=" + pageNumber
				+ ", type=" + type + "]";
	}

}
