package com.kukuruznyak.springmvc.mvc.conversion;

import com.kukuruznyak.springmvc.mvc.model.Event;
import com.kukuruznyak.springmvc.mvc.model.Router;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Class converts field of type Date to type String
 * for mapping web-model to server-model.
 * For backwards use method convertToEvent()
 */
public class EventConversion {
    private Long id;
    private String name;
    private String location;
    private String dateFrom;
    private String dateTo;

    public EventConversion() {
    }

    public EventConversion(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.location = event.getLocation();
        this.dateFrom = String.valueOf(event.getDateFrom());
        this.dateTo = String.valueOf(event.getDateTo());
    }

    public Event convertToEvent() {
        Event event = new Event();
        event.setId(this.id);
        event.setName(this.name);
        event.setLocation(this.location);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            event.setDateFrom(dateFormat.parse(this.dateFrom));
        } catch (ParseException e) {
            event.setDateFrom(new Date());
            e.printStackTrace();
        }
        try {
            event.setDateTo(dateFormat.parse(this.dateTo));
        } catch (ParseException e) {
            event.setDateTo(new Date());
            e.printStackTrace();
        }
        return event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}
