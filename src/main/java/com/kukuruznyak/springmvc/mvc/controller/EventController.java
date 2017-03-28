package com.kukuruznyak.springmvc.mvc.controller;

import com.kukuruznyak.springmvc.mvc.conversion.EventConversion;
import com.kukuruznyak.springmvc.mvc.model.Event;
import com.kukuruznyak.springmvc.mvc.service.EventService;
import com.kukuruznyak.springmvc.mvc.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/event/*")
public class EventController {

    private final EventService eventService;
    private final RouterService routerService;

    @Autowired
    public EventController(EventService eventService, RouterService routerService) {
        this.eventService = eventService;
        this.routerService = routerService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getEvents() {
        ModelAndView modelAndView = new ModelAndView("event");
        List eventList = eventService.getAllEvents();
        modelAndView.addObject("eventList", eventList);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEventById(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("eventDetails");
        modelAndView.addObject("operationWithEvent", "edit");
        modelAndView.addObject("event", new EventConversion(eventService.getEventById(id)));
        modelAndView.addObject("routers", routerService.getRoutersByEventId(id));
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView updateEvent(@PathVariable("id") Long id, @ModelAttribute("event") EventConversion eventConversion, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("eventDetails");
        modelAndView.addObject("operationWithEvent", "edit");
        if (eventService.isCorrectEvent(eventConversion.convertToEvent())) {
            eventService.saveEvent(eventConversion.convertToEvent());
            session.setAttribute("errorMessage", "");
            modelAndView.addObject("event", new EventConversion(eventService.getEventById(id)));
        } else {
            session.setAttribute("errorMessage", "Incorrect date!");
            modelAndView.addObject("event", eventConversion);
        }


        modelAndView.addObject("routers", routerService.getRoutersByEventId(id));
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addEvent() {
        ModelAndView modelAndView = new ModelAndView("eventDetails");
        modelAndView.addObject("operationWithEvent", "add");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEvent(@ModelAttribute("event") EventConversion eventConversion, HttpSession session) {
        Event event = null;
        ModelAndView modelAndView = new ModelAndView("eventDetails");
        modelAndView.addObject("operationWithEvent", "edit");

        if (eventService.isCorrectEvent(eventConversion.convertToEvent())) {
            Event newEvent = eventService.saveEvent(eventConversion.convertToEvent());
            session.setAttribute("errorMessage", "");
            return "redirect:/event/edit/" + newEvent.getId();
        } else {
            session.setAttribute("errorMessage", "Incorrect date!");
            return "redirect:/event/add";
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEventById(@PathVariable("id") Long id) {
        eventService.deleteEventById(id);
        return "redirect:/event/list";
    }
}