package com.app.repository;

import com.app.model.Event;
import com.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByOrganizer(User organizer);

    List<Event> findByName(String name);

    List<Event> findByDate(LocalDate date);

    List<Event> findByTime(LocalTime time);

    List<Event> findByLocation(String location);

    List<Event> findByDurationGreaterThanEqual(int duration);
}
