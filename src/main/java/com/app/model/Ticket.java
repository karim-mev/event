package com.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "ticket_type", nullable = false)
    private String ticketType;

    @Column(name = "price", nullable = false)
    private double price;

    // Constructors
    public Ticket() {
    }

    public Ticket(Event event, String ticketType, double price) {
        this.event = event;
        this.ticketType = ticketType;
        this.price = price;
    }

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString method (for debugging/logging purposes)
    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", event=" + event.toString() +
                ", ticketType='" + ticketType + '\'' +
                ", price=" + price +
                '}';
    }
}

