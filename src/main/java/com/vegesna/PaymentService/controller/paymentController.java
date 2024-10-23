package com.vegesna.PaymentService.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegesna.PaymentService.DTO.paymentRequest;
import com.vegesna.PaymentService.service.paymentService;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/payment")
public class paymentController {

    private paymentService paymentService;

    public paymentController(paymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String intiatePayment(@RequestBody paymentRequest paymentRequest){
        try{
            return this.paymentService.intiatePayment(paymentRequest.getOrderId(), paymentRequest.getAmount());

        }catch(Exception e){
            System.out.println("error is  " + e);
            return "error";
        }
    }

}
