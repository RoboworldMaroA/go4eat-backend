package com.managecustomers.security.auth;

import com.managecustomers.security.trip.Trip;
import com.managecustomers.security.trip.TripService;
import com.managecustomers.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class AuthenticationController {

    //inject class
    private final AuthenticationService service;
    private final TripService tripService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
        @RequestBody RegisterRequest request
    ){
        //this register method need to be implemented in AuthenticationService class
        return ResponseEntity.ok(service.register(request));
    }



    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){

        //
        return ResponseEntity.ok(service.authenticate(request));
    }

    //Get all user details Method in AuthenticationService getAllUsers() allows me to get a users.
    @GetMapping("/allUsers")
    public List<User> getUsers() {
        return service.getAllUsers();
    }


    //Get Trip data from secured link, only authenticated users can get access to the database
    @GetMapping(path = ("/trip"))
    public List<Trip> getTrip() {
        return tripService.getTrip();
    }


    //Delete user only if is authenticated
    @DeleteMapping(path = "/trip/{tripId}")
    public void deleteTrip(@PathVariable("tripId") Integer Id) {
        tripService.deleteTrip(Long.valueOf(Id));
    }




}
