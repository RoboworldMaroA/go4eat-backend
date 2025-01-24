package com.managecustomers.security.form;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;



@Configuration
public class FormConfig {

    @Bean
    CommandLineRunner commandLineRunnerForm(FormRepository formRepository){
        return args -> {
            Form Form1 = new Form(
                    "Marek",
                    "Augustyn",
                    "dddd",
                    "sss"


            );



            //now we tell that we want save customer using list

            formRepository.saveAll(

                    List.of((Form1))
            );
        };


    }
}
