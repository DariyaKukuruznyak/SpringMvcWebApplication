package com.kukuruznyak.springmvc.mvc.controller;

import com.kukuruznyak.springmvc.mvc.model.Router;
import com.kukuruznyak.springmvc.mvc.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouterController {

    private final RouterService routerService;

    @Autowired
    public RouterController(RouterService routerService) {
        this.routerService = routerService;
    }

    @RequestMapping(value = "event/{eventId}/router/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getRouterById(@PathVariable("eventId") Long eventId, @PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("routerDetails");
        modelAndView.addObject("operationWithRouter", "edit");
        modelAndView.addObject("router", routerService.getRouterById(id));
        return modelAndView;
    }

    @RequestMapping(value = "event/{eventId}/router/edit/{routerId}", method = RequestMethod.POST)
    public String updateRouter(@ModelAttribute("router") Router router, @PathVariable("eventId") Long eventId,
                               @PathVariable("routerId") Long routerId) {
        router.setId(routerId);
        routerService.updateRouter(router, eventId);
        return "redirect:/event/edit/" + eventId;
    }

    @RequestMapping(value = "event/{eventId}/router/add", method = RequestMethod.GET)
    public ModelAndView addRouter(@PathVariable("eventId") Long eventId) {
        ModelAndView modelAndView = new ModelAndView("routerDetails");
        modelAndView.addObject("eventId", eventId);
        modelAndView.addObject("operationWithRouter", "add");
        return modelAndView;
    }

    @RequestMapping(value = "event/{eventId}/router/add", method = RequestMethod.POST)
    public String addRouter(@ModelAttribute("router") Router router, @PathVariable("eventId") Long eventId) {
        routerService.saveRouter(router, eventId);
        return "redirect:/event/edit/" + eventId;
    }

    @RequestMapping(value = "event/{eventId}/router/delete/{id}", method = RequestMethod.GET)
    public String deleteRouterById(@PathVariable("id") Long id, @PathVariable("eventId") Long eventId) {
        routerService.deleteRouterById(id);
        return "redirect:/event/edit/" + eventId;
    }
}
