package com.yaashall.bankapp.service;

import com.yaashall.bankapp.dto.EmailMessage;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String senderEmail;


    @Override
    public void sendEmail(EmailMessage emailMessage) {
        log.info("Sending email to: {}", emailMessage.getToAddress());
        if (emailMessage.isHtml()){
            sendHtmlEmail(emailMessage);
        } else {
            sendSimpleEmail(emailMessage);
        }
    }

    @Override
    public void sendSimpleEmail(EmailMessage emailMessage) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(senderEmail);
            message.setTo(emailMessage.getToAddress());
            message.setSubject(emailMessage.getSubject());
            message.setText(emailMessage.getBody());

            javaMailSender.send(message);
            log.info("Sent email to {}", emailMessage.getToAddress());

        }catch (Exception e){
            log.error("Email sending failed", e);

        }

    }

    @Override
    public void sendHtmlEmail(EmailMessage emailMessage) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(senderEmail);
            helper.setTo(emailMessage.getToAddress());
            helper.setSubject(emailMessage.getSubject());
            helper.setText(emailMessage.getBody(), true);

            javaMailSender.send(message);
            log.info("Sent email to {}", emailMessage.getToAddress());

        } catch(MessagingException e){
            log.error("Email sending failed", e);

        }


    }

    @Override
    public void sendAlertEmail(EmailMessage emailMessage) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(senderEmail);
            message.setTo(emailMessage.getToAddress());
            message.setSubject(emailMessage.getSubject());
            message.setText(emailMessage.getBody());

            javaMailSender.send(message);
            log.info("Sent alert email to {}", emailMessage.getToAddress());

        }catch(MailException e){
            log.error("Email sending failed", e);
        }

    }

    @Override
    public void sendEmailWithAttachment(EmailMessage emailMessage) {

    }


    @Override
    public void accountCreationEmail(EmailMessage emailMessage) {
        try {
            String template = loadEmailTemplate("account-creation-template.html");
            String htmlContent = prepareHtmlContent(template, emailMessage.getToAddress(), "YSL.", "2023");

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(senderEmail);
            helper.setTo(emailMessage.getToAddress());
            helper.setSubject(emailMessage.getSubject());
            helper.setText(htmlContent,  emailMessage.isHtml());

            javaMailSender.send(message);
            log.info("Sent account creation email to {}", emailMessage.getToAddress());
        } catch (MessagingException e) {
            log.error("Error sending account creation email", e);
        }
    }



    public String loadEmailTemplate(String templateName){
        InputStream inputStream = getClass()
                                    .getResourceAsStream("/templates/email-templates/" + templateName);

        if (inputStream == null){
            throw new RuntimeException("Could not read template");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String prepareHtmlContent(String template, String userName, String companyNamr, String Year){
        return template.replace("[Name]", userName)
                        .replace("[Company Name]", companyNamr)
                        .replace("[Year]", Year);
    }


}


