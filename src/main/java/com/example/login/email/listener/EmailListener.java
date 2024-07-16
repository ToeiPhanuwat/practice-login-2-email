package com.example.login.email.listener;

import com.example.login.common.EmailRequest;
import com.example.login.email.service.EmailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmailListener {

    private final EmailService emailService;

    public EmailListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "activation-email")
    public void listenerForActivationEmail(EmailRequest emailRequest) {
        log.info("kafka received: " + emailRequest.getTo());
        log.info(emailRequest.getContent());

        // ส่งข้อมูลที่รับมาจาก kafka ไปยังผู้รับ
        emailService.send(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getContent());
    }

    @KafkaListener(topics = "password-reset-email")
    public void listenerForPasswordReset(EmailRequest emailRequest) {
        log.info("kafka received: " + emailRequest.getTo());
        log.info(emailRequest.getContent());

        // ส่งข้อมูลที่รับมาจาก kafka ไปยังผู้รับ
        emailService.send(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getContent());
    }
}
