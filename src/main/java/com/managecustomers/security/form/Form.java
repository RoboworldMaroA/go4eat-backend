package com.managecustomers.security.form;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "form")
public class Form{

    //variable id is generated automatically
    @Id
    @SequenceGenerator(
            name = "form_sequence",
            sequenceName = "form_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "form_sequence"

    )

    @Column(name="formId")
    private Long formId;


    //variable trip name
    private String firstnameForm;

//    @Column(
//            name = "customerId",
//            nullable = false,
//            columnDefinition = "TEXT"
//    )
//    private String customerId;

//    @Column(
//            name = "weatherId",
//            nullable = false,
//            columnDefinition = "TEXT"
//    )
//    private String weatherId;

    //    @Id
//    @SequenceGenerator(
//            name = "listId_sequence",
//            sequenceName = "ListId_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "ListId_sequence"
//
//    )
    private String lastnameForm;
//    private Boolean camera;
//    private Boolean camcorder;
//    private Boolean smartphone;
//    private String ireland;
//    private Boolean spain;
//    private LocalDate departureDay;
//    private LocalDate returnDay;
//    private Boolean trekking;
    private String emailForm;
    private String question1;




//    private Boolean adminPrivileges;
//    private Boolean payStatus;
//    private Boolean smallLuggage;
//    private Boolean mediumLuggage;
//    private Boolean largeLuggage;
//    private Boolean plane;
//    private Boolean beachListStatus;
//    private Boolean bus;
//    private Boolean train;
//    private Boolean poland;
//    private Boolean summer;
//    private Boolean winter;
//    private Boolean spring;
//    private Boolean autumn;
//    private Boolean car;
//    private Boolean ski;
//    private Boolean documentsListStatus;
//    private Boolean essentialListStatus;
//    private String destination;
//    private Boolean female;
//    private String sex;
//    private Boolean laptop;
//    private Boolean tablet;
//    private Boolean drone;
//    @Transient//this tell this colum (age) no need to be more in database table
//    private Integer age;

    //empty constructor
    public Form() {
    }


    //constructor

    public Form(Long formId, String firstnameForm, String lastnameForm, String emailForm, String question1) {
        this.formId = formId;
        this.firstnameForm = firstnameForm;
        this.lastnameForm = lastnameForm;
        this.emailForm = emailForm;
        this.question1 = question1;
    }


    //constructor with auto generated  id

    public Form(String firstnameForm, String lastnameForm, String emailForm, String question1) {
        this.firstnameForm = firstnameForm;
        this.lastnameForm = lastnameForm;
        this.emailForm = emailForm;
        this.question1 = question1;
    }


    //Setters and getters


    public Long getformId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getFirstnameForm() {
        return firstnameForm;
    }

    public void setFirstnameForm(String firstnameForm) {
        this.firstnameForm = firstnameForm;
    }

    public String getLastnameForm() {
        return lastnameForm;
    }

    public void setLastnameForm(String lastnameForm) {
        this.lastnameForm = lastnameForm;
    }

    public String getEmailForm() {
        return emailForm;
    }

    public void setEmailForm(String emailForm) {
        this.emailForm = emailForm;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + formId +
                ", firstnameForm='" + firstnameForm + '\'' +
                ", lastnameForm='" + lastnameForm + '\'' +
                ", emailForm='" + emailForm + '\'' +
                ", question1='" + question1 + '\'' +
                '}';
    }


}
