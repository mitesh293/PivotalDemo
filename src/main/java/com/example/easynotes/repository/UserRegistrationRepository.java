package com.example.easynotes.repository;

import com.example.easynotes.model.Note;
import com.example.easynotes.model.UserRegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRegistrationRepository extends JpaRepository<UserRegistrationModel, Long> {

    @Query("SELECT t FROM UserRegistrationModel t where lower(t.firstName) = :firstName AND t.password = :password")
    public Optional<UserRegistrationRepository> validateLoginUser(@Param("firstName") String firstName,
                                                                          @Param("password") String password);

}
