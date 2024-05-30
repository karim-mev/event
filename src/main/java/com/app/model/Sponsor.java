package com.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sponsors")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sponsor_id")
    private int sponsorId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "contact_email")
    private String contactEmail;

    // Constructors
    public Sponsor() {
    }

    public Sponsor(String name, String description, String contactPerson, String contactEmail) {
        this.name = name;
        this.description = description;
        this.contactPerson = contactPerson;
        this.contactEmail = contactEmail;
    }

    // Getters and Setters
    public int getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(int sponsorId) {
        this.sponsorId = sponsorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    // toString method (for debugging/logging purposes)
    @Override
    public String toString() {
        return "Sponsor{" +
                "sponsorId=" + sponsorId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                '}';
    }
}
