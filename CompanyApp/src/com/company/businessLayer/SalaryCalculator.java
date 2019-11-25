package com.company.businessLayer;

public class SalaryCalculator {
	
	static float allowance;
	public static float calculateSalary(int experience, float basicSalary){
		if(experience<=2)
			allowance=basicSalary*(30/100);
		else if(experience<=4)
			allowance=basicSalary*(40/100);
		else if(experience<=6)
			allowance=basicSalary*(50/100);
		else
			allowance=basicSalary*(65/100);	
		return allowance;
	}

}
