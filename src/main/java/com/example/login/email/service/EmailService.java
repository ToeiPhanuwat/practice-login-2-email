package com.example.login.email.service;

public interface EmailService {

    void send(String to, String subject, String html);
}
