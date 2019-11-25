package com.company.entities;

import com.company.businessLayer.SalaryCalculator;

public class Employee extends Person{
	
	private String empId;
	private float basicSalary;
	private int experience;
	
	public Employee(){
		super();
	}
	
	public Employee(String empId,float basicSalary, int experience){
		super();
		this.empId=empId;
		this.basicSalary=basicSalary;
		this.experience=experience;
	}
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public float getSalary(float basicSalary,int experience){
		
		float allowance=SalaryCalculator.calculateSalary(experience,basicSalary);
		return allowance+basicSalary;
		
	}

}
