package com.kh.dc.gallary;

public class Gallary {

	private int gal_no;
	private String gal_name;
	public Gallary() {
		super();
	}
	public Gallary(int gal_no, String gal_name) {
		super();
		this.gal_no = gal_no;
		this.gal_name = gal_name;
	}
	public int getGal_no() {
		return gal_no;
	}
	public void setGal_no(int gal_no) {
		this.gal_no = gal_no;
	}
	public String getGal_name() {
		return gal_name;
	}
	public void setGal_name(String gal_name) {
		this.gal_name = gal_name;
	}
	@Override
	public String toString() {
		return "Gallary [gal_no=" + gal_no + ", gal_name=" + gal_name + "]";
	}
	
}
