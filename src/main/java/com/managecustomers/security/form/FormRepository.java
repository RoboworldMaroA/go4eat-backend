package com.managecustomers.security.form;

import com.managecustomers.security.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FormRepository extends JpaRepository<Form, Long>{



    //customer class and long because ID is long

        //we want to find customer using specific email - to do that we have can use Optional imported from Java package
//    @Query("SELECT s FROM Trip s WHERE s.tripName = ?1")
        Optional<Form> findFormByFirstnameForm(String firstnameForm);


}
