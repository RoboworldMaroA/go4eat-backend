package com.managecustomers.security.form;

import com.managecustomers.security.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {

    private final FormRepository formRepository;

    @Autowired
    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public List<Form> getForm(){
        return formRepository.findAll();
    }//end method getTrip


    public void addNewForm(Form form) {
//            Optional<Form> formOptional = formRepository.findFormByFirstnameForm(form.getFirstnameForm());

//            System.out.println("Is trip name in database? "+formOptional.isPresent());

            //I wont check if the name exist, I want to add always new form even if the name is same
            //When I do this like that I can make a 2 identical forms
//            if (formOptional.isPresent()) {
//                throw new IllegalStateException("Trip with that name is existing change the name please!");
//            }

//            if (formOptional.isPresent()) {
//                String duplicateForm = form.getFirstnameForm() + 1;
//                System.out.println("DuplicateForm name");
//                System.out.println(duplicateForm);
//                formRepository.save(form);
//
//            }


            //System.out.println(form);//For Testing Only

            //instead of printing form we want to save new form
            System.out.println("I am in form service in method addNewForm. Form name is: "+form.getFirstnameForm());
            formRepository.save(form);



    }
}
