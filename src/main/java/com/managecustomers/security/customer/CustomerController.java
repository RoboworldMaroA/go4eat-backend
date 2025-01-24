package com.managecustomers.security.customer;

/*
SmartLuggage Application
Marek Augustyn
12 May 2022
SmartLuggage CustomerController class it is where the data from the front end are going on the beginning of the process
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// in this class we implement GET, POST,PUT, DELETE
//This class accept the request from the front end and send back responses.
//this is a proper way
// !!!! we could have rest controller in main restfull app but this is not a good practice do this that way
@CrossOrigin(origins = {"https://smartluggage.herokuapp.com","https://localhost:3000","https://smartluggage-ijzs3.ondigitalocean.app","https://smartluggage2023.ew.r.appspot.com"})//this is for Deploy
//@CrossOrigin(origins = "http://localhost:3000")//this is for Development for Not SSL
//@CrossOrigin(origins = "*")

@RestController
@RequestMapping(path = "/api/v1/customer")
public class  CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //printing list of the students GET method
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    //**********   POST *******************************************
    //@PostMapping(value = "/api/v1/customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
    }//end POST

    //**********   DELETE     *******************************************
    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId) {
        customerService.deleteCustomer(customerId);
    }

    //**********   PUT      *******************************************
    // put update data in the customer for example we want ot change name and email
    @PutMapping(path = "{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Long customerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        customerService.updateCustomer(customerId, name, email);
    }

    //************** Login verification *****************

    // path is http://localhost:8080/api/v1/customer/login
    @GetMapping("/login")
    public void loginCustomers(@RequestParam(required = false) String email,
                               @RequestParam(required = false) String password) {
        customerService.loginCustomers(email, password);
    }
}