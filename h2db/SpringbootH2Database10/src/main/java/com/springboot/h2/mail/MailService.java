package com.springboot.h2.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.recruitingWorkflowApp.model.Process;

import javax.mail.*;
import javax.mail.internet.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

@Component
public class MailService {

    @Autowired
    ProcessService processService;

    private Session prepareSMTPSession() {
//ustawienia poczty wychodzącej
        final String username = "twójmail@gmail.com";
        final String password = "hasło";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");//TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        return session;
    }

    private void sendEmail(Session session, String body) throws MessagingException {

        Message message = new MimeMessage(session); //message implementuje Part, a MimeMessage implementuje MimePart
        message.setFrom(new InternetAddress("twójmail@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("maildocelowy@gmail.com"));
        message.setSubject("Notify from RecruitingWorkflowApp");
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(body, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);
        Transport.send(message);
    }

    @Scheduled(cron = "0 0 0/1 1/1 * *")
    public void executeTask() {
        System.out.println("Scheduler działa");
        Session session = prepareSMTPSession();

        for (Process process : processService.getAll()) {
            if (process.getDate() != null && !process.getDate().isEmpty()) {//metoda isEmpty() klasy String sprawdza, czy ten ciąg znaków jest pusty, czy nie. True, jeśli ciąg znaków jest pusty, w przeciwnym razie false.
                String date = process.getDate();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateTime = LocalDate.parse(date, formatter);

                if (dateTime.minusDays(1).isEqual(LocalDate.now())) {//Metoda isEqual() interfejsu ChronoLocalDate sprawdza, czy ta data jest równa podanej dacie, czy nie.
                    try {
                        sendEmail(session, "Zbliza sie koniec rekrutacji na stanowisko :" + process.getPosition());

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

    }
}