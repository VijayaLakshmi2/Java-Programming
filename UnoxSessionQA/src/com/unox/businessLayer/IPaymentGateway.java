package com.unox.businessLayer;
import com.unox.entities.Payment;

interface IPaymentGateway {
	boolean processPayment(Payment payment);
}
