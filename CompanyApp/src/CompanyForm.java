import com.company.businessLayer.Company;
import com.company.entities.Employee;
import com.company.entities.Person;

public class CompanyForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		float totalSalary;
		Person emp=new Employee("emp1", 20000.54f,2);
	
		totalSalary=((Employee) emp).getSalary(((Employee) emp).getBasicSalary(), ((Employee) emp).getExperience());
		
		Company company=new Company();
		company.addPersons(emp);
		
		System.out.println();
		
		
		
	}

}
