package com.app.repository;

import com.app.model.Registration;
import com.app.model.User;
import com.app.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

    List<Registration> findByUser(User user);

    List<Registration> findByEvent(Event event);

    List<Registration> findByUserAndEvent(User user, Event event);

}

