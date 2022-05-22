package com.vegetables.website.controller;

import com.stripe.exception.StripeException;
import com.stripe.exception.APIException;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.CardException;
import com.stripe.model.Charge;
import com.vegetables.website.model.ChargeRequest;
import com.vegetables.website.model.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ChargeController {

    @Autowired
    private StripeService paymentsService;

    @PostMapping("/charge")
    public ResponseEntity<?> charge(@RequestBody ChargeRequest chargeRequest) throws APIConnectionException, APIException, AuthenticationException, InvalidRequestException, CardException {
        chargeRequest.setDescription("VeggieBox Order");
        chargeRequest.setCurrency("GBP");
        Charge charge = paymentsService.charge(chargeRequest);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(StripeException.class)
    public ResponseEntity<?> handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return ResponseEntity.internalServerError().build();
    }
}
