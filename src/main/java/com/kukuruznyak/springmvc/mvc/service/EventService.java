package com.kukuruznyak.springmvc.mvc.service;

import com.kukuruznyak.springmvc.mvc.model.Event;
import com.kukuruznyak.springmvc.mvc.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional
    public Event saveEvent(Event event) {
        return this.eventRepository.save(event);
    }

    @Transactional
    public void deleteEventById(Long id) {
        if (eventRepository.findOne(id) != null) {
            eventRepository.delete(id);
        }
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findOne(id);
    }

    public boolean isCorrectEvent(Event event) {
        return event.getDateFrom().getTime() <= event.getDateTo().getTime();
    }
}
