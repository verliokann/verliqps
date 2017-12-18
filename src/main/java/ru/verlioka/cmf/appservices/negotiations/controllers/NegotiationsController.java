package ru.verlioka.cmf.appservices.negotiations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.negotiations.services.concrete.virtual.NegotiationsService;

import java.util.List;

@Controller
@RequestMapping("/chapurin")
public class NegotiationsController {

    @Autowired
    NegotiationsService negotiationsService;

    @RequestMapping(value = "/negotiationQuery/{id}/subscribe", method = RequestMethod.GET)
    public
    @ResponseBody
    List getSubscribersByNegotiationQuery(@PathVariable long id) {
        return negotiationsService.getSubscribersByNegotiationQuery(id);
    }

    @RequestMapping(value = "/negotiationCriteria/{id}/subscribe", method = RequestMethod.GET)
    public
    @ResponseBody
    List getSubscribersByNegotiationCriteria(@PathVariable long id) {
        return negotiationsService.getSubscribersByNegotiationQuery(id);
    }

    @RequestMapping(value = "/negotiationCriteria/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    List getNegotiationCriteria(@PathVariable long id) {
        return negotiationsService.getNegotiationCriteria(id);
    }

    @RequestMapping(value = "/negotiationQuery/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    List getNegotiationQuery(@PathVariable long id) {
        return negotiationsService.getNegotiationsQuery(id);
    }




}
