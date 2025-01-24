package com.managecustomers.security.auth;

import com.managecustomers.security.config.JwtService;
import com.managecustomers.security.form.Form;
import com.managecustomers.security.trip.TripRepository;
import com.managecustomers.security.user.Role;
import com.managecustomers.security.user.User;
import com.managecustomers.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

     //get access to database
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    //Authentication bean
    private final AuthenticationManager authenticationManager;

    //This method allows us to save to database and get generated token
    public AuthenticationResponse register(RegisterRequest request) {
        //check if user email is empty
        if(request.getEmail().equals(" ")){
            System.out.println("Email can not be empty.");
        }
        //check if user exist
        Optional<User> userOptional = repository.findByEmail(request.getEmail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("Email exist in database.");
        }

            //create user object of that request
            var user = User.builder()
                    .firstName(request.getFirstname())
                    .lastName(request.getLastname())
                    .email(request.getEmail())
                    //this need inject PasswordEncoder
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            repository.save(user);

            //to get a token need inject jwt class
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();



    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
                );
        //if program go to ths place it means that there was ok, password and email was ok
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken =  jwtService.generateToken(user)  ;
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public List<User> getAllUsers() {
            return repository.findAll();
    }


    //implementation delete user
    public void deleteUser(Integer userId) {

        boolean exists = repository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("Customer with id: "+ userId+" does not exist.");
        }
        //otherwise, - method deleteById is from SpringFramework
        repository.deleteById(userId);

    }

    public void updateUser(Integer userId, User request) {

        repository.findById(userId)
                .map(user -> {
                    user.setLastName(request.getLastName());
                    user.setFirstName(request.getFirstName());
                    user.setEmail(request.getEmail());
                    user.setPassword(passwordEncoder.encode(request.getPassword()));
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    User user = new User();
                    user.setLastName(request.getLastName());
                    user.setFirstName(request.getFirstName());
                    user.setEmail(request.getEmail());
                    user.setPassword(passwordEncoder.encode(request.getPassword()));
                    return repository.save(user);
                });


    }






}
