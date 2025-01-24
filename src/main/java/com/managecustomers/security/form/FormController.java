package com.managecustomers.security.form;

import com.managecustomers.security.form.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin(origins = {"https://smartluggage.herokuapp.com","https://localhost:3000","https://smartluggage-ijzs3.ondigitalocean.app","https://smartluggage2023.ew.r.appspot.com"})
@RestController
@RequestMapping
public class FormController {

    private final FormService formService;

    @Autowired
    public FormController(FormService formService) {
        this.formService = formService;
    }


    //printing list of the trip GET method
    @GetMapping(path = ("/api/v1/form"))
    public List<Form> getForm() {

        return formService.getForm();
    }



    //**********   POST *******************************************
    @PostMapping(path = ("/api/v1/form"))
    public void registerNewForm(@RequestBody Form form) {

        formService.addNewForm(form);
    }//end POST



}
