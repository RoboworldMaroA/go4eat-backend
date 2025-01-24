package com.managecustomers.security.emaiSenderService;

/*
In this class I will define url and opperation that will be executed when user send a data
So, instead of passing data from main class I will be passing data recived from the website and put them to the
service and service sen an email
 */

import com.managecustomers.security.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"https://smartluggage.herokuapp.com","https://localhost:3000",
        "https://smartluggage-ijzs3.ondigitalocean.app","https://smartluggage2023.ew.r.appspot.com",
        "https://go4eat.eu", "https://go4eat-mih6g.ondigitalocean.app"

})
@RestController
@RequestMapping
public class EmailController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @GetMapping(path = ("/api/v1/email"))
    public List<Email> getEmail(){
        return emailSenderService.getEmail();
    }


    //**********   POST *******************************************
    @PostMapping(path = ("/api/v1/email"))
    public void registerNewEmail(@RequestBody Email email) {
        emailSenderService.sendNewEmail(email);
    }//end POST
}
