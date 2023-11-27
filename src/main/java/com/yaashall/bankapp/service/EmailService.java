package com.yaashall.bankapp.service;

import com.yaashall.bankapp.dto.EmailMessage;

public interface EmailService {
    void sendEmail(EmailMessage emailMessage);

    void sendSimpleEmail(EmailMessage emailMessage);

    void sendHtmlEmail(EmailMessage emailMessage);

    void sendAlertEmail(EmailMessage emailMessage);


    void sendEmailWithAttachment(EmailMessage emailMessage);

    void accountCreationEmail(EmailMessage emailMessage);


}
