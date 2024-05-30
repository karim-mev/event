package com.app.services;

import com.app.model.Venue;
import com.app.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    private final VenueRepository venueRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    public Optional<Venue> getVenueById(int id) {
        return venueRepository.findById(id);
    }

    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public Venue updateVenue(int id, Venue updatedVenue) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id: " + id));

        venue.setName(updatedVenue.getName());
        venue.setAddress(updatedVenue.getAddress());
        venue.setCapacity(updatedVenue.getCapacity());
        venue.setDescription(updatedVenue.getDescription());

        return venueRepository.save(venue);
    }

    public void deleteVenue(int id) {
        venueRepository.deleteById(id);
    }
}
