package com.app.services;

import com.app.model.Sponsor;
import com.app.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorService {

    private final SponsorRepository sponsorRepository;

    @Autowired
    public SponsorService(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    public Optional<Sponsor> getSponsorById(int id) {
        return sponsorRepository.findById(id);
    }

    public Sponsor createSponsor(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    public Sponsor updateSponsor(int id, Sponsor updatedSponsor) {
        Sponsor sponsor = sponsorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sponsor not found with id: " + id));

        sponsor.setName(updatedSponsor.getName());
        sponsor.setDescription(updatedSponsor.getDescription());
        sponsor.setContactPerson(updatedSponsor.getContactPerson());
        sponsor.setContactEmail(updatedSponsor.getContactEmail());

        return sponsorRepository.save(sponsor);
    }

    public void deleteSponsor(int id) {
        sponsorRepository.deleteById(id);
    }
}
