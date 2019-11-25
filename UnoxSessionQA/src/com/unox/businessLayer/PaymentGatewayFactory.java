package com.unox.businessLayer;

class PaymentGatewayFactory {

	private PaymentGatewayFactory()
	{
		
	}
	
	public static IPaymentGateway create(String choice){
		IPaymentGateway gateway = null;
		if(choice == "PayPal"){
			gateway = new PayPalGateway();
		}
		
		return gateway;
	}
}
