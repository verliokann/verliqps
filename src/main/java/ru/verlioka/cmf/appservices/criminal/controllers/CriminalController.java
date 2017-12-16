package ru.verlioka.cmf.appservices.criminal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.verlioka.cmf.appservices.criminal.services.concrete.virtual.CriminalService;
import ru.verlioka.cmf.appservices.criminal.services.concrete.report.ReportCriminalService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/criminal")
public class CriminalController
{
    @Autowired
    private ReportCriminalService reportCriminalService;
    @Autowired
    private CriminalService criminalService;

    @RequestMapping(method = RequestMethod.GET)
    public void generateReport(HttpServletResponse response) throws Exception 
    {
        byte[] data = reportCriminalService.generatePdf(criminalService.getAll());
                
        //criminalService.getNotProccessed();
        
        System.out.println();
        
        streamReport(response, data, "report1.pdf");
    }
    
    protected void streamReport(HttpServletResponse response, byte[] data, String name)    throws IOException 
    {
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + name);
        response.setContentLength(data.length);

        response.getOutputStream().write(data);
        response.getOutputStream().flush();
    }
}
