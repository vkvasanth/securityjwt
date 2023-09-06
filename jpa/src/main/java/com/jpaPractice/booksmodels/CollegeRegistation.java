package com.jpaPractice.booksmodels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="college")
public class CollegeRegistation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int RegNO;
	private String name;
	@Column(name="deptname")
	private String departmentname;
	@Column(name="phonenumber")
	private int ph_no;
	@OneToOne
	@JoinColumn(name="busno")
	private BusRoute busroute;
public CollegeRegistation()
{
	
}
	public CollegeRegistation(int regNO, String name, String departmentname, int ph_no, BusRoute busroute) {
		super();
		RegNO = regNO;
		this.name = name;
		this.departmentname = departmentname;
		this.ph_no = ph_no;
		this.busroute = busroute;
	}

	public int getRegNO() {
		return RegNO;
	}

	public void setRegNO(int regNO) {
		RegNO = regNO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public int getPh_no() {
		return ph_no;
	}

	public void setPh_no(int ph_no) {
		this.ph_no = ph_no;
	}

	public BusRoute getBusroute() {
		return busroute;
	}

	public void setBusroute(BusRoute busroute) {
		this.busroute = busroute;
	}

	@Override
	public String toString() {
		return "CollegeRegistation [RegNO=" + RegNO + ", name=" + name + ", departmentname=" + departmentname
				+ ", ph_no=" + ph_no + ", busroute=" + busroute + "]";
	}
	

}
