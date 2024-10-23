package com.vegesna.PaymentService.paymentGateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class RazorPayPaymentGateway implements paymentGateway{

    private RazorpayClient RazorpayClient;

    public RazorPayPaymentGateway(RazorpayClient RazorpayClient) throws RazorpayException{
        this.RazorpayClient = RazorpayClient;
    }

    @Override
    public String generatePaymentLink(Long orderId, Long amount) throws RazorpayException {

        // ORDER DETAILS
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount); // 1000 - > 10.00
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", 1729686605);
        paymentLinkRequest.put("reference_id", orderId.toString());
        paymentLinkRequest.put("description","Payment for orderId " + orderId.toString());


        // CUSTOMER DETAILS
        JSONObject customer = new JSONObject();
        customer.put("name","+918639404463");
        customer.put("contact","VEGESNA VAMSI");
        customer.put("email","vamsivegesna123@gmail.com");
        paymentLinkRequest.put("customer",customer);


        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);

        // notify details..
        paymentLinkRequest.put("notify",notify);
//        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
//        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com/academy/instructor-dashboard/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink link = RazorpayClient.paymentLink.create(paymentLinkRequest);

        return link.toString();
    }
    

}
