package com.kh.dc.gallary;

public class Board {

	private String gal_name;
	private int b_no;
	private String title;
	public Board() {
		super();
	}
	public Board(String gal_name, int b_no, String title) {
		super();
		this.gal_name = gal_name;
		this.b_no = b_no;
		this.title = title;
	}
	public String getGal_name() {
		return gal_name;
	}
	public void setGal_name(String gal_name) {
		this.gal_name = gal_name;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Board [gal_name=" + gal_name + ", b_no=" + b_no + ", title=" + title + "]";
	}
	
}
