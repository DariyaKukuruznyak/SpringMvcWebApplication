package com.kukuruznyak.springmvc.mvc.service;

import com.kukuruznyak.springmvc.mvc.model.Event;
import com.kukuruznyak.springmvc.mvc.model.Router;
import com.kukuruznyak.springmvc.mvc.repository.RouterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RouterService {

    private final RouterRepository routerRepository;
    private final EventService eventService;

    @Autowired
    public RouterService(RouterRepository routerRepository, EventService eventService) {
        this.routerRepository = routerRepository;
        this.eventService = eventService;
    }

    @Transactional
    public void updateRouter(Router newRouter, Long eventId) {
        Event event = eventService.getEventById(eventId);
        Router router = routerRepository.findOne(newRouter.getId());
        router.setRouterName(newRouter.getRouterName());
        router.setApMac(newRouter.getApMac());
        router.setEvent(event);
        try {
            routerRepository.save(router);
        } catch (JpaSystemException e) {
            //TODO
        }
    }

    @Transactional
    public void saveRouter(Router router, Long eventId) {
        Event event = eventService.getEventById(eventId);
        router.setEvent(event);
        try {
            routerRepository.save(router);
        } catch (JpaSystemException e) {
            //TODO
        }
    }

    @Transactional
    public void deleteRouterById(Long id) {
        if (routerRepository.findOne(id) != null) {
            routerRepository.delete(id);
        }
    }

    public List<Router> getRoutersByEventId(Long eventId) {
        return routerRepository.getAllRoutersByEventId(eventId);
    }

    public Router getRouterById(Long id) {
        return routerRepository.findOne(id);
    }
}
