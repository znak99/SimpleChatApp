package com.example.SampleChatApp.mail;

import com.example.SampleChatApp.Dto.MailDto;

import javax.mail.MessagingException;

public interface EmailService {
    public void sendMail(MailDto mailDto) throws MessagingException;
}
