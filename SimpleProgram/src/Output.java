import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Output {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			int i,sum;
			sum=10;
			for (i=-1;i<3;++i)
				sum=(sum/i);
		}
			catch(ArithmeticException e){
				System.out.println("0");
			}
			
		System.out.println(sum);
		
	}

}
