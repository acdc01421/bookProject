package org.thinker.vo;

import java.sql.Date;

public class BookVO {

	protected int bno;
	protected String image;
	protected String title;
	protected String author;
	protected int pYear;
	protected long isbn;
	protected String publisher;
	protected String status;
	protected Date regDate;
	protected String description;
	protected String category;

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getpYear() {
		return pYear;
	}

	public void setpYear(int pYear) {
		this.pYear = pYear;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}



	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "BookVO [bno=" + bno + ", image=" + image + ", title=" + title
				+ ", author=" + author + ", pYear=" + pYear + ", isbn=" + isbn
				+ ", publisher=" + publisher + ", status=" + status
				+ ", regDate=" + regDate + ", description=" + description
				+ ", category=" + category + "]";
	}



}
