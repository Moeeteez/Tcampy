package com.example.TunisiaCamp.Controllers;

import com.example.TunisiaCamp.Services.MailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("Mail")

public class MailController {

    public class EmailController {

        @Autowired
         MailService emailService;

        @PostMapping("/send-email")
        public ResponseEntity<Void> sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
            emailService.sendEmail(to, subject, body);
            return ResponseEntity.ok().build();
        }
    }
}
