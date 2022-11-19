package ru.verlioka.cmf.appservices.yandexmapsample.services.concrete.report;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ru.verlioka.cmf.appservices.yandexmapsample.models.VirtualObject;

import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportGenerationServiceImpl implements ReportGenerationService {

    public static void main(String[] args) throws IOException {
        new ReportGenerationServiceImpl().generatePfd();
    }

    private static File createPDF(String pdfFilename, List<VirtualObject> objects) {

        Document doc = new Document();
        PdfWriter docWriter = null;

        DecimalFormat df = new DecimalFormat("0.00");
        File res = null;
        try {

            //special font sizes
            Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);

            //file path
            String path = pdfFilename;
            File temp = Files.createTempFile(pdfFilename, ".tmp").toFile();
            res = temp;
            docWriter = PdfWriter.getInstance(doc, new FileOutputStream(temp));

            //document header attributes
            doc.addAuthor("Roman Chernyshev");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("google.ru");
            doc.addTitle("Virtual object report");
            doc.setPageSize(PageSize.LETTER);

            //open document
            doc.open();
            BaseFont times =
                    BaseFont.createFont("c:/windows/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);

            //create a paragraph
            Paragraph paragraph = new Paragraph("List of virtual objects: ", new Font(times, 14));


            //specify column widths
            float[] columnWidths = {1.5f, 2f, 2f, 5f};
            //create PDF table with the given widths
            PdfPTable table = new PdfPTable(columnWidths);
            // set table width a percentage of the page width
            table.setWidthPercentage(90f);
            Font timeFont = new Font(times, 12, Font.NORMAL);

            //insert column headings
            insertCell(table, "Name", Element.ALIGN_RIGHT, 1, timeFont);
            insertCell(table, "latitude", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "longitude", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Description", Element.ALIGN_RIGHT, 1, timeFont);
            table.setHeaderRows(1);

            for (VirtualObject object : objects) {
                insertCell(table, object.getName(), Element.ALIGN_RIGHT, 1, timeFont);
                insertCell(table, "" + object.getLatitude(), Element.ALIGN_LEFT, 1, bf12);
                insertCell(table, "" + object.getLongitude(), Element.ALIGN_LEFT, 1, bf12);
                insertCell(table, object.getDescription(), Element.ALIGN_RIGHT, 1, timeFont);
            }

            insertCell(table, "All count...", Element.ALIGN_RIGHT, 3, bfBold12);
            insertCell(table, "" + objects.size(), Element.ALIGN_RIGHT, 1, bfBold12);

            //add the PDF table to the paragraph
            paragraph.add(table);
            // add the paragraph to the document
            doc.add(paragraph);
            return res;
        } catch (DocumentException dex) {
            dex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (doc != null) {
                //close the document
                doc.close();
            }
            if (docWriter != null) {
                //close the writer
                docWriter.close();
            }
            return res;
        }
    }

    private static void insertCell(PdfPTable table, String text, int align, int colspan, Font font) {

        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
        //set the cell alignment
        cell.setHorizontalAlignment(align);
        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);
        //in case there is no text and you wan to create an empty row
        if (text.trim().equalsIgnoreCase("")) {
            cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);

    }

    public byte[] generatePfd() throws IOException {

        String pdfFilename = "test.pdf";
        List<VirtualObject> objects = new ArrayList<>();
        VirtualObject obj1 = new VirtualObject();
        obj1.setName("obj1");
        obj1.setLatitude(11.33f);
        obj1.setLongitude(91.15f);
        obj1.setDescription("Mmm, my favorite object");
        VirtualObject obj2 = new VirtualObject();
        obj2.setName("obj2");
        obj2.setLatitude(22.44f);
        obj2.setLongitude(41.15f);
        obj2.setDescription("Mmm, what an object");
        VirtualObject obj3 = new VirtualObject();
        obj3.setName("obj3");
        obj3.setLatitude(33.11f);
        obj3.setLongitude(61.15f);
        obj3.setDescription("Mmm, the best of the best");
        objects.add(obj1);
        objects.add(obj2);
        objects.add(obj3);
        File pdf = createPDF(pdfFilename, objects);
        if (pdf != null) {
            return Files.readAllBytes(pdf.toPath());
        }
        System.out.println("Return 0");
        return new byte[0];
    }

    @Override
    public byte[] generatePdf(List<VirtualObject> list) throws IOException {
        String pdfFilename = "test.pdf";
        File pdf = createPDF(pdfFilename, list);
        if (pdf != null) {
            return Files.readAllBytes(pdf.toPath());
        }
        System.out.println("Return 0");
        return new byte[0];
    }
}
