package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.game_store.model.Registration;
import com.game_store.repository.RegistrationRepository;
import com.game_store.service.RegistrationService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> registrationList = registrationService.getAllRegistrations();
        return new ResponseEntity<>(registrationList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable("id") int id) {
        Optional<Registration> registration = registrationService.getRegistrationById(id);
        return registration.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Registration> createRegistration(@Valid @RequestBody Registration registration) {
        try {
            Registration createdRegistration = registrationService.saveRegistration(registration);
            return new ResponseEntity<>(createdRegistration, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable("id") int id, @Valid @RequestBody Registration registration) {
        try {
            Registration updatedRegistration = registrationService.updateRegistration(id, registration);
            return new ResponseEntity<>(updatedRegistration, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable("id") int id) {
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Registration>> getRegistrationsByUser(@PathVariable("userId") int userId) {
        List<Registration> registrations = registrationService.getRegistrationsByUser(userId);
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Registration>> getRegistrationsByEvent(@PathVariable("eventId") int eventId) {
        List<Registration> registrations = registrationService.getRegistrationsByEvent(eventId);
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }
}

