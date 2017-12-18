package ru.verlioka.cmf.appservices.sidorova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.sidorova.models.HelperModel;
import ru.verlioka.cmf.appservices.sidorova.models.PaperModel;
import ru.verlioka.cmf.appservices.sidorova.services.paper.PaperService;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@Controller
@EnableTransactionManagement
public class PaperController {
    @Autowired
    private PaperService paperService;

    @RequestMapping (value = "/getpapers", method = RequestMethod.GET)
    public
    @ResponseBody
    List <PaperModel> getPapers(){
        return paperService.getPapers();
    }

    @RequestMapping (value = "/getpaperscrit", method = RequestMethod.GET)
    public
    @ResponseBody
    List <PaperModel> getPapersCrit(){
        return paperService.getPapersCrit();
    }

    @RequestMapping (value = "/getcompanies", method = RequestMethod.GET)
    public
    @ResponseBody
    List <PaperModel> getCompany(){
        return paperService.getCompany();
    }

    @RequestMapping (value = "/getcompaniescrit", method = RequestMethod.GET)
    public
    @ResponseBody
    List <PaperModel> gerCompanyCrit() {
        return paperService.gerCompanyCrit();
    }

    @RequestMapping (value = "/getstocks", method = RequestMethod.GET)
    public
    @ResponseBody
    List <HelperModel> getStocks(){
        return paperService.getStocks();
    }
}
