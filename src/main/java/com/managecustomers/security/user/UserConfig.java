package com.managecustomers.security.user;

import com.managecustomers.security.form.Form;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@Configuration
public class UserConfig {

    private final PasswordEncoder passwordEncoder;

    public UserConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


//    @Bean
//    CommandLineRunner commandLineRunnerUser(UserRepository userRepository) {
//        return args -> {
//            User AdminMaro = new User(
//                    1,
//                    "MaroAdmin",
//                    "Augustyn",
//                    "maro@o2.pl",
//                    passwordEncoder.encode("pass"),
//                    "userName",
//                     new Form("form1","dont know","details","what you want")  ,
//                    Role.USER
//
//
//
//
//            );
//
//
//            userRepository.saveAll(List.of(AdminMaro)
//            );
//
//        };
//
//
//    }

//    @Bean
//    CommandLineRunner commandLineRunnerUser(UserRepository userRepository) {
//        return args -> {
//            User AdminMaro = new User(
//                    1,
//                    "MaroAdmin",
//                    "Augustyn",
//                    "maro@o2.pl",
//                    passwordEncoder.encode("pass"),
//                    "userName",
//                    List.of(new Form("form1","dont know","details","what you want"), new Form("form2","dont know 2","details 2","what you want 2")) ,
//                    Role.USER
//
//
//
//
//            );
//
//
//            userRepository.saveAll(List.of(AdminMaro)
//            );
//
//        };
//
//
//    }



    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository userRepository) {
        return args -> {
            User AdminMaro = new User(
                    1,
                    "MaroAdmin",
                    "Augustyn",
                    "maro@o2.pl",
                    passwordEncoder.encode("pass"),
                    "userName",
                    List.of(new Form("form1","dont know","details","what you want"), new Form("form2","dont know 2","details 2","what you want 2")) ,
                    Role.USER

            );


            userRepository.saveAll(List.of(AdminMaro)
            );

        };


    }


}