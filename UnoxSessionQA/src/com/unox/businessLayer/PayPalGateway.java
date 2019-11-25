package com.unox.businessLayer;
import com.unox.entities.Payment;

class PayPalGateway implements IPaymentGateway {

	public boolean processPayment(Payment payment){
		boolean isProcessed = false;
		
		//Call PayPal API which is external
		PayPalExternalGateway gateway = new PayPalExternalGateway();
		isProcessed = gateway.makePayment();
		
		return isProcessed;
	}
}
