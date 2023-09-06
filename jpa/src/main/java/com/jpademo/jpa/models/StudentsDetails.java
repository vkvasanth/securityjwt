package com.jpademo.jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(StudentsPrimarykey.class)
public class StudentsDetails {
	@Id
		private int studid;
	@Id
		private int courseid;
		private int mark;
		public StudentsDetails()
		{
			super();
		}
		public StudentsDetails(int studid, int courseid, int mark) {
			super();
			this.studid = studid;
			this.courseid = courseid;
			this.mark = mark;
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
		public int getMark() {
			return mark;
		}
		public void setMark(int mark) {
			this.mark = mark;
		}
		@Override
		public String toString() {
			return "StudentsDetails [studid=" + studid + ", courseid=" + courseid + ", mark=" + mark + "]";
		}
		
}
