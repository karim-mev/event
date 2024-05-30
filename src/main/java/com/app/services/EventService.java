package com.app.services;

import com.app.model.Event;
import com.app.repository.EventRepository;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public List<com.app.model.Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(int id) {
        return eventRepository.findById(id);
    }

    public List<Event> getEventsByOrganizer(int organizerId) {
        return eventRepository.findByOrganizer(userRepository.findById(organizerId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + organizerId)));
    }

    public List<Event> getEventsByName(String name) {
        return eventRepository.findByName(name);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(int id, Event updatedEvent) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));

        event.setName(updatedEvent.getName());
        event.setDescription(updatedEvent.getDescription());
        event.setDate(updatedEvent.getDate());
        event.setTime(updatedEvent.getTime());
        event.setDuration(updatedEvent.getDuration());
        event.setLocation(updatedEvent.getLocation());

        return eventRepository.save(event);
    }

    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }
}

