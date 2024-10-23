package com.vegesna.PaymentService.service;

import org.springframework.stereotype.Service;

import com.razorpay.RazorpayException;
import com.vegesna.PaymentService.paymentGateways.paymentGateway;

@Service
public class paymentService {

    private paymentGateway paymentGateway;

    public paymentService(paymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public String intiatePayment(Long orderId, Long amount) throws RazorpayException{
        return paymentGateway.generatePaymentLink(orderId, amount);
    }
}
