import com.unox.businessLayer.BookingManager;
import com.unox.entities.Booking;
import com.unox.entities.CardInfo;
import com.unox.entities.Customer;
import com.unox.entities.Multiplex;
import com.unox.entities.Payment;
import com.unox.entities.Schedule;
import com.unox.entities.Screen;
import com.unox.entities.ScreenClass;

public class UnoxForm {

	public static void main(String[] args){
		
		//Multiplex was being constructed
		Multiplex multiplex = new Multiplex();
		multiplex.setName("Unox");

		//Lets build screens for the multiplex
		Screen screenA = new Screen();
		screenA.setId(1);
		screenA.setName("Atmos");
		
		ScreenClass atmosClassGold = new ScreenClass();
		atmosClassGold.setId(1);
		atmosClassGold.setName("Gold");
		atmosClassGold.setNumberOfSeats(150);
		
		ScreenClass atmosClassSilver = new ScreenClass();
		atmosClassSilver.setId(2);
		atmosClassSilver.setName("Silver");
		atmosClassSilver.setNumberOfSeats(200);
		
		//Now ScreenA has both Gold and Silver Class
		screenA.addScreenClass(atmosClassGold);
		screenA.addScreenClass(atmosClassSilver);
		
		//Add the screen to the multiplex
		multiplex.addScreen(screenA);
		
		//Now lets see what is there in the Multiplex
		showMultiplexInfo(multiplex);
		
		//Multiplex has schedule for movies which customers book
		Schedule schedule = new Schedule();
		//We will be adding the screen, movie and show
		
		
		//Customer walks in and wants to book tickets
		Customer customer = new Customer();
		Schedule mySchedule = new Schedule();
		//Add the movie and show you want to book
		
		Booking booking = new Booking(mySchedule);
		CardInfo cardInfo = new CardInfo();
		cardInfo.setCardNo(11111111);
		cardInfo.setCvv(276);
		cardInfo.setName("KK");
		booking.setPayment(new Payment(cardInfo));
		booking.getPayment().setChoice("PayPal");
		booking.setCustomer(customer);
		
		BookingManager manager = new BookingManager();
		boolean isBooked = manager.bookTicket(booking);
		
		if(isBooked)
			System.out.println("Booking Successful");
		
		//1. Fill all the objects
		//2. Write Methods in the same class
		//2.a List of all Movies
		//2.b List of all Schedules
		//2.c List of all StarCast for a Movie
		
		//3. Introduce BillDesk
		//4. Introduce PayTm
		//5. Make your Factory - Satisfy OCP
	}
	
	public static void showMultiplexInfo(Multiplex multiplex){
		
		System.out.println("Name of the Multiplex");
		System.out.println(multiplex.getName());
		
		System.out.println("Number of Screens");
		System.out.println(multiplex.getScreens().size());
	}
}
