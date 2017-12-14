package ru.verlioka.cmf.appservices.criminal.services.concrete.report;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ru.verlioka.cmf.appservices.criminal.models.Criminal;

import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportCriminalServiceImpl implements ReportCriminalService
{
    public static void main(String[] args) throws IOException 
    {
        new ReportCriminalServiceImpl().generatePfd();
    }

    private static File createPDF(String pdfFilename, List<Criminal> objects) 
    {
        Document doc = new Document();
        PdfWriter docWriter = null;

        DecimalFormat df = new DecimalFormat("0.00");
        File res = null;
        try 
        {
            //special font sizes
            Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);

            //file path
            String path = pdfFilename;
            File temp = File.createTempFile(pdfFilename, ".tmp");
            res = temp;
            docWriter = PdfWriter.getInstance(doc, new FileOutputStream(temp));

            //document header attributes
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("google.ru");
            doc.addTitle("Уголовнички");
            doc.setPageSize(PageSize.LETTER);

            doc.open();
            BaseFont times = BaseFont.createFont("c:/windows/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
            Paragraph paragraph = new Paragraph("Список уголовников: ", new Font(times, 14));

            float[] columnWidths = {1.5f, 2f, 5f};
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(90f);
            Font timeFont = new Font(times, 12, Font.NORMAL);
            Font boldFont = new Font(times, 12, Font.BOLD);

            insertCell(table, "ФИО", Element.ALIGN_RIGHT, 1, boldFont);
            insertCell(table, "Погоняло", Element.ALIGN_RIGHT, 1, boldFont);
            insertCell(table, "Статья", Element.ALIGN_RIGHT, 1, boldFont);
            table.setHeaderRows(1);

            for (Criminal object : objects) 
            {
                insertCell(table, object.getFullName(), Element.ALIGN_RIGHT, 1, timeFont);
                insertCell(table, object.getNick(), Element.ALIGN_RIGHT, 1, timeFont);
                insertCell(table, object.getArticle(), Element.ALIGN_RIGHT, 1, timeFont);
            }

            insertCell(table, "Всего", Element.ALIGN_RIGHT, 2, bfBold12);
            insertCell(table, "" + objects.size(), Element.ALIGN_RIGHT, 1, bfBold12);
            
            insertCell(table, "Нераскрытых", Element.ALIGN_RIGHT, 2, bfBold12);
            insertCell(table, "" + objects.size(), Element.ALIGN_RIGHT, 1, bfBold12);

            paragraph.add(table);
            doc.add(paragraph);
            return res;
        } 
        catch (DocumentException dex)
        {
            dex.printStackTrace();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        } 
        finally 
        {
            if (doc != null) 
            {
                doc.close();
            }
            if (docWriter != null) 
            {
                docWriter.close();
            }
            return res;
        }
    }

    private static void insertCell(PdfPTable table, String text, int align, int colspan, Font font)
    {
        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
        //set the cell alignment
        cell.setHorizontalAlignment(align);
        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);
        //in case there is no text and you wan to create an empty row
        if (text.trim().equalsIgnoreCase("")) 
        {
            cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);
    }

    public byte[] generatePfd() throws IOException 
    {       
        return new byte[0];
    }

    @Override
    public byte[] generatePdf(List<Criminal> list) throws IOException 
    {
        String pdfFilename = "test.pdf";
        File pdf = createPDF(pdfFilename, list);
        if (pdf != null) 
        {
            return Files.readAllBytes(pdf.toPath());
        }
        System.out.println("Return 0");
        return new byte[0];
    }
}
