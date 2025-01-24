package com.managecustomers.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAndFormService {
    private final UserRepository userRepository;

    @Autowired
    public UserAndFormService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getForm(){
        return userRepository.findAll();
    }//end method getTrip
    public void addNewUserAndForm(User user) {
//
        System.out.println("I am in form service in method addNewForm. Form name is: "+user.getFirstName());
        userRepository.save(user);



    }


}
