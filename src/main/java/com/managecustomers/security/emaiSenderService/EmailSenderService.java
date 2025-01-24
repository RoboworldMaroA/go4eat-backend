package com.managecustomers.security.emaiSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailSenderService {

    private final EmailRepository emailRepository;


    //Define variable mailSender and create constructor and then autowired
    private final JavaMailSender mailSender;

    @Autowired
    public EmailSenderService(EmailRepository emailRepository, JavaMailSender mailSender) {
        this.emailRepository = emailRepository;
        this.mailSender = mailSender;
    }


    //Method used to send email, setFrom is my email that I want to use to sending an emails
    //In this method are variable defined in the class Email and passed from the controller to this function
    public void sendEmail(String toEmail,
                          String subject,
                          String body){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("info.go4eat@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

       mailSender.send(message);
        System.out.println("Backend was restarted and now in on again.");

    }


    public List<Email> getEmail() {
            return emailRepository.findAll();
        }//end method getTrip


    //add email data to database and send an email
//    public void sendNewEmail(Email email) {
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("info.go4eat@gmail.com");
//        message.setTo(email.getToEmail());
//        message.setText(email.getBody());
//        message.setSubject(email.getSubject());
//
//        mailSender.send(message);
//
//        System.out.println("Mail sent successfully from sendNewEmail service... ");
//
//        emailRepository.save(email);
//
//    }

    //New version sending email to the info@go4eat.eu
    public void sendNewEmail(Email email) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("info.go4eat@gmail.com");
        message.setTo(email.getToEmail());
        message.setText("Thank you for contacting us. This is an automatic reply. We will contact you shortly.");
//        message.setText(email.getBody());
//        message.setSubject(email.getSubject());
        message.setSubject("Thank You for you message");

        mailSender.send(message);
        System.out.println("Mail sent successfully from sendNewEmail service... ");

        emailRepository.save(email);
        message.setFrom("info.go4eat@gmail.com");
        message.setTo("info@go4eat.eu");
        message.setText("You got an message from:  "+ email.getSubject()+
                "   His email is:  "+email.getToEmail()+
                "   Message is:  "+email.getBody()
        );
        message.setSubject("Email from the Contact Us form on go4eat.eu");
        mailSender.send(message);

    }




}

