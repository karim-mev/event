package com.app.repository;

import com.app.model.Ticket;
import com.app.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByEvent(Event event);

}

