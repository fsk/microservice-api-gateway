package org.fsk.paymentservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${project.description}")
    private String description;

    @GetMapping("/project")
    public String getDescription() {
        return description;
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/info")
    public ResponseEntity<String> showPaymentInfo() {
        return ResponseEntity.ok("FROM PAYMENT SERVICE, Port# is: " + port);
    }
}
