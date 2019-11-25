import com.banking.entities.Account;
import com.banking.entities.SavingsAccount;
import com.bnking.bussinessLayer.AccountManagerFactory;
import com.bnking.bussinessLayer.IAccountManager;

public class AccountForm {

	public static final void main(String[] args) {
		// TODO Auto-generated method stub
		
		//IAccountManager accountManager=AccountManagerFactory.Create("Savings");
		
		Account account=new SavingsAccount();
		
		System.out.println("Login");
	}
	public AccountForm(String data){
		
	}
	public AccountForm(int data){
		
	}
}
