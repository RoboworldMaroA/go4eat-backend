package com.managecustomers.security.demo;

import com.managecustomers.security.auth.AuthenticationService;
import com.managecustomers.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
//@CrossOrigin
public class DemoController {
    private final AuthenticationService service;

    @GetMapping("/demo-controller")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from secured end point");
    }


    @GetMapping("/allUsers")
    public List<User> getUsers() {
        return service.getAllUsers();
    }


    @GetMapping("/allUsers2")
    public ResponseEntity<List<User>> getUsers2() {
        return ResponseEntity.ok(service.getAllUsers());
    }

}
