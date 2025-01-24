package com.managecustomers.security.emaiSenderService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmailConfig {
    @Bean
    CommandLineRunner commandLineRunnerEmail(EmailRepository emailRepository) {
        return args -> {
            Email welcomEmail = new Email(
                    //,
                    "welcome@email",
                    "Display when server was restarted",
                    "Display when server was restarted"
            );
            emailRepository.saveAll(List.of(welcomEmail));

        };

    }

    ;
}





