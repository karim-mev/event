package com.app.controller;

import com.app.model.Sponsor;
import com.app.services.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sponsors")
public class SponsorController {

    private final SponsorService sponsorService;

    @Autowired
    public SponsorController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    @GetMapping
    public ResponseEntity<List<Sponsor>> getAllSponsors() {
        List<Sponsor> sponsorList = sponsorService.getAllSponsors();
        return new ResponseEntity<>(sponsorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sponsor> getSponsorById(@PathVariable("id") int id) {
        Optional<Sponsor> sponsor = sponsorService.getSponsorById(id);
        return sponsor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Sponsor> createSponsor(@Valid @RequestBody Sponsor sponsor) {
        try {
            Sponsor createdSponsor = sponsorService.createSponsor(sponsor);
            return new ResponseEntity<>(createdSponsor, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sponsor> updateSponsor(@PathVariable("id") int id, @Valid @RequestBody Sponsor sponsor) {
        try {
            Sponsor updatedSponsor = sponsorService.updateSponsor(id, sponsor);
            return new ResponseEntity<>(updatedSponsor, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSponsor(@PathVariable("id") int id) {
        sponsorService.deleteSponsor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
