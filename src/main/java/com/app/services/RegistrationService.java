package com.app.services;

import com.app.model.Registration;
import com.app.repository.RegistrationRepository;
import com.app.repository.UserRepository;
import com.app.repository.EventRepository;
import com.app.repository.TicketRepository;
import com.app.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository, UserRepository userRepository, EventRepository eventRepository, TicketRepository ticketRepository) {
        this.registrationRepository = registrationRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Optional<Registration> getRegistrationById(int id) {
        return registrationRepository.findById(id);
    }

    public List<Registration> getRegistrationsByUser(int userId) {
        // get the user by id then get registrations
        return registrationRepository.findByUser(userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId)));
    }

    public List<Registration> getRegistrationsByEvent(int eventId) {
        // get the event by id then get registrations
        return registrationRepository.findByEvent(eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId)));
    }

    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    public Registration updateRegistration(int id, Registration updatedRegistration) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id: " + id));

        registration.setUser(updatedRegistration.getUser());
        registration.setEvent(updatedRegistration.getEvent());
        registration.setTicket(updatedRegistration.getTicket());
        registration.setRegistrationDate(updatedRegistration.getRegistrationDate());

        return registrationRepository.save(registration);
    }

    public void deleteRegistration(int id) {
        registrationRepository.deleteById(id);
    }
}

