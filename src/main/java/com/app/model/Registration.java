package com.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private int registrationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    // Constructors
    public Registration() {
    }

    public Registration(User user, Event event, Ticket ticket, LocalDateTime registrationDate) {
        this.user = user;
        this.event = event;
        this.ticket = ticket;
        this.registrationDate = registrationDate;
    }

    // Getters and Setters
    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    // toString method (for debugging/logging purposes)
    @Override
    public String toString() {
        return "Registration{" +
                "registrationId=" + registrationId +
                ", user=" + user.toString() +
                ", event=" + event.toString() +
                ", ticket=" + ticket.toString() +
                ", registrationDate=" + registrationDate +
                '}';
    }
}

