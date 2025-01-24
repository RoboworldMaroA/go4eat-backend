package com.managecustomers.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {
    //I am finding by email, but you can use by name or other what you need
    Optional<User> findByEmail(String email);

}
