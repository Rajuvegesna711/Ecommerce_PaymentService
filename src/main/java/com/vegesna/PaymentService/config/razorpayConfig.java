package com.vegesna.PaymentService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Configuration
public class razorpayConfig {

    @Value("${razorpay.key.id.Razorpay}")
    private String razorPayId;

    @Value("${razorpay.key.secret.Razorpay}")
    private String razorPaySecret;

    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException{
        System.out.println(razorPayId + "  " + razorPaySecret);
        return new RazorpayClient(razorPayId, razorPaySecret);
    }
}
