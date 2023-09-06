package com.jpademo.jpa.models;

public class StudentsPrimarykey {
	private int studid;
	private int courseid;
	public StudentsPrimarykey()
	{
		super();
	}
	public StudentsPrimarykey(int studid, int courseid) {
		super();
		this.studid = studid;
		this.courseid = courseid;
	}
	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	

}
