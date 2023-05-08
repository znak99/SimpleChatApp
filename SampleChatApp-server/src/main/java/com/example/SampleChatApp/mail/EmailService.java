package com.example.SampleChatApp.mail;

import javax.mail.MessagingException;

public interface EmailService {
    public void sendMail(MailDto mailDto) throws MessagingException;
}
