package com.managecustomers.security.user;


import com.managecustomers.security.auth.AuthenticationService;
import com.managecustomers.security.form.Form;
import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//16 Aug 2024
// I want to add a @OneToMany for the form, I want to be sure that user may have many forms and,
// it will be displaying all the forms user have
@RestController
@RequestMapping
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class UserController {
    //It uses service to save
    private final AuthenticationService service;

    //Second service from user with the form used to saving new user with the form inside
    private final UserAndFormService userAndFormService;


    //Display welcome with the info of the server site
    @GetMapping("/")
    public String welcome() {
//        return ("<h1>Welcome in the backend CRUD, SPRING SECURITY with JWT used on SmartLuggage </h1>");
        return ("<h1>Welcome in the backend CRUD, SPRING SECURITY with JWT used on go4eat.eu </h1>");
    }

    //It is used in fullstackBootstrap manage-users web app
    //printing list of the users GET method
    @GetMapping("/displayUsers")
    public List<User> getUsers() {
        return service.getAllUsers();
    }


    //**********   DELETE     *******************************************
    @DeleteMapping(path = "/displayUsers/{userId}")
    public void deleteUser(  @PathVariable("userId") Integer userId){
        service.deleteUser(userId);
    }


    //**********   PUT      *******************************************
    // put update data in the customer for example we want ot change name and email
    @PutMapping("/displayUsers/{userId}")
    public void updateUser(@PathVariable("userId") Integer userId,
                               @RequestBody User request){
            service.updateUser(userId,request);
    }


    //Post URL to save new user with the form
    //**********   POST *******************************************
    @PostMapping(path = ("/registerUserAndForm"))
    public void registerNewUserAndForm(@RequestBody User user) {

        userAndFormService.addNewUserAndForm(user);
    }//end POST





}
