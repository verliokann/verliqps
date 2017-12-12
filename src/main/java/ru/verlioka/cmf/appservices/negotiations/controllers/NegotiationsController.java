package ru.verlioka.cmf.appservices.negotiations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.negotiations.models.NegotiationsTable;
import ru.verlioka.cmf.appservices.negotiations.models.SubscribeTable;
import ru.verlioka.cmf.appservices.negotiations.services.concrete.virtual.NegotiationsService;

import java.util.List;

@Controller
@EnableTransactionManagement
public class NegotiationsController {

    @Autowired
    NegotiationsService negotiationsService;

    @RequestMapping(value = "/negotiation/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    NegotiationsTable getNegotiation(@PathVariable long id) {
        return negotiationsService.getNegotiation(id);
    }

    @RequestMapping(value = "/negotiation", method = RequestMethod.GET)
    public
    @ResponseBody
    List<NegotiationsTable> getAllNegotiation() {
        return negotiationsService.getAllNegotiations();
    }


    @RequestMapping(value = "/negotiation/{id}/subscribe", method = RequestMethod.GET)
    public
    @ResponseBody
    List<SubscribeTable> getSubscribersByNegotiation(@PathVariable long id) {
        return negotiationsService.getSubscribersByNegotiation(id);
    }

    @RequestMapping(value = "/subscribe", method = RequestMethod.GET)
    public
    @ResponseBody
    List<SubscribeTable> getAllSubscribers() {
        return negotiationsService.getAllSubscribers();
    }


}
