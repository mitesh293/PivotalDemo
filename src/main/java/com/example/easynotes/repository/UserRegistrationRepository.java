package com.example.easynotes.repository;

import com.example.easynotes.model.Note;
import com.example.easynotes.model.UserRegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<UserRegistrationModel, Long> {
}
