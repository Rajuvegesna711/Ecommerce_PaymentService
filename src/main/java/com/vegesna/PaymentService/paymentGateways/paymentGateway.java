package com.vegesna.PaymentService.paymentGateways;

import com.razorpay.RazorpayException;

public interface paymentGateway {
    String generatePaymentLink(Long orderId, Long amount) throws RazorpayException;
}
