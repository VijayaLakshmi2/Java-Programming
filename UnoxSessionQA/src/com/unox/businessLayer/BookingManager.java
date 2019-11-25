package com.unox.businessLayer;
import com.unox.entities.Booking;
import com.unox.entities.Payment;

public class BookingManager {

	public boolean bookTicket(Booking booking){
	
		boolean bookingStatus = false;
		
		//Here is where you are going to write the logic
		//1. Check if the seats are available
		//Lets say your wrote logic to check availability
		boolean isAvailable = checkAvailability(booking);
		
		//2. Block Tickets
		//Lets say you wrote logic to block tickets
		if(isAvailable){
			boolean isBlocked = blockTicket(booking);
			
			if(isBlocked){
				//3. Process Payment
				boolean isProcessed = processPayment(booking.getPayment());
				
				if(isProcessed)
					bookingStatus = true;
			}
		}
			
		return bookingStatus;
	}

	private boolean processPayment(Payment payment) {
		boolean isProcessed = false;
		
		IPaymentGateway gateway = PaymentGatewayFactory.create(payment.getChoice());
		isProcessed = gateway.processPayment(payment);
		
		return isProcessed;
	}

	private boolean checkAvailability(Booking booking) {
		// TODO Auto-generated method stub
		boolean available = false;
		
		//This is the logic
		//Lets say it is available
		available = true;
		
		return available;
	}
	
	private boolean blockTicket(Booking booking) {
		// TODO Auto-generated method stub
		boolean blocked = false;
		
		//This is the logic
		//Lets say it is blocked
		blocked = true;
		
		return blocked;
	}
}
