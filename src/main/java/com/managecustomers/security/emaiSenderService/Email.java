package com.managecustomers.security.emaiSenderService;

import jakarta.persistence.*;
@Entity(name = "Email")
@Table
public class Email {

    @Id
    @SequenceGenerator(
            name = "email_sequence",
            sequenceName = "email_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "email_sequence"
    )
    @Column(name="id",
            updatable = false)
    private Long id;

    @Column(
            name = "toEmail",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String toEmail;


    @Column(
            name = "subject",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String subject;

    @Column(
            name = "body",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String body;




    public Email(Long id, String toEmail, String subject, String body) {
        this.id = id;
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
    }

    public Email() {

    }

    public Email(String toEmail, String subject, String body) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", toEmail='" + toEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
