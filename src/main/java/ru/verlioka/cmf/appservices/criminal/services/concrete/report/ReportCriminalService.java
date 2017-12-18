package ru.verlioka.cmf.appservices.criminal.services.concrete.report;

import java.io.IOException;
import java.util.List;

import ru.verlioka.cmf.appservices.criminal.models.Criminal;
import ru.verlioka.cmf.appservices.yandexmapsample.models.VirtualObject;

public interface ReportCriminalService 
{
    public byte[] generatePdf(List<Criminal> list) throws IOException;
}
