package com.unox.businessLayer;

//This is a webservice given by PayPal. This is an external API
class PayPalExternalGateway {

	public boolean makePayment(){
		boolean isProcessed = false;
		
		//Logic that is performed by PayPal
		//if payment is successful then true
		isProcessed = true;
		
		return isProcessed;
	}
}
