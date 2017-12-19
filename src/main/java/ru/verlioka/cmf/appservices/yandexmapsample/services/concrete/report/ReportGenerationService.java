package ru.verlioka.cmf.appservices.yandexmapsample.services.concrete.report;

import java.io.IOException;
import java.util.List;

import ru.verlioka.cmf.appservices.yandexmapsample.models.VirtualObject;

public interface ReportGenerationService {
    public byte[] generatePdf(List<VirtualObject> list) throws IOException;
}
