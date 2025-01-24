package com.managecustomers.security.trip;

/*
SmartLuggage Application

*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// in this class we implement GET, POST,PUT, DELETE
//this is a proper way we could have rst controller in main restfull app but
// this is good practice do this that way
//@CrossOrigin(origins = "https://frontendsmartluggage.herokuapp.com/")
//@RequestMapping(path = "/api/v1/trip")
@CrossOrigin(origins = {"https://smartluggage.herokuapp.com","https://localhost:3000","https://smartluggage-ijzs3.ondigitalocean.app","https://smartluggage2023.ew.r.appspot.com"})
@RestController
@RequestMapping
public class TripController {
    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    //printing list of the trip GET method
    @GetMapping(path = ("/api/v1/trip"))
    public List<Trip> getTrip() {

        //THIS IS FOR TEST ONLY
//            return List.of(new Student(1L,
//                    "Marek",
//                    "Augustyn",
//                    LocalDate.of(2000, Month.MAY,2),
//                    21

//
//                    ));

        return tripService.getTrip();
    }

    //implementation post
    // add new trip
    //request body is a trip data

    //**********   POST *******************************************
    @PostMapping(path = ("/api/v1/trip"))
    public void registerNewTrip(@RequestBody Trip trip) {
        tripService.addNewTrip(trip);
    }//end POST


    //**********   DELETE     *******************************************
    @DeleteMapping(path = "/api/v1/trip/{tripId}")
    public void deleteTrip(@PathVariable("tripId") Integer Id) {
        tripService.deleteTrip(Long.valueOf(Id));
    }



    //**********   PUT      *******************************************
    // put update data in the student for example we want ot change name and email
    @PutMapping(path = "/api/v1/trip/{tripId}")
    public void updateTrip(
            @PathVariable("tripId") Long tripId,
            @RequestParam(required = false) String tripName
            //@RequestParam(required = false) String listId

    ) {
//        tripService.updateTrip(tripId,name,listId);
        tripService.updateTrip(tripId, tripName);
    }



    //************** Login verification *****************
/*
    @PostMapping
    public void verificationCustomerLogin(@RequestBody Customer customer, String email, String customerPassword){
        customerService.verifyCustomerPassword(customer,email, customerPassword);
    }*/

}
