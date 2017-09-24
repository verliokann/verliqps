package ru.verlioka.cmf.appservices.yandexmapsample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.verlioka.cmf.appservices.yandexmapsample.services.concrete.report.ReportGenerationService;
import ru.verlioka.cmf.appservices.yandexmapsample.services.concrete.virtual.VirtualObjectService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/mapreport")
public class MapReportController {

    @Autowired
    private ReportGenerationService reportGenerationService;
    @Autowired
    private VirtualObjectService virtualObjectService;

    @RequestMapping(method = RequestMethod.GET)
    public void generateReport(HttpServletResponse response) throws Exception {

        byte[] data = reportGenerationService.generatePdf(virtualObjectService.getAll());

        streamReport(response, data, "report.pdf");
    }

    protected void streamReport(HttpServletResponse response, byte[] data, String name)
            throws IOException {

        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + name);
        response.setContentLength(data.length);

        response.getOutputStream().write(data);
        response.getOutputStream().flush();
    }
}
