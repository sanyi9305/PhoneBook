/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.sun.javafx.font.FontFactory;
import java.io.FileOutputStream;
import javafx.collections.ObservableList;

public class PdfGenerator {

    public void pdfGenerator(String filename, ObservableList<Person> data) {
        Document document = new Document();

        try {

            //Logo elhelyezése
            PdfWriter.getInstance(document, new FileOutputStream(filename + ".pdf"));
            document.open();
            Image image1 = Image.getInstance(getClass().getResource("/logo.jpg"));
            image1.scaleToFit(400, 150);
            image1.setAbsolutePosition(170f, 650f);
            document.add(image1);
                
            document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n"));
            //Táblázat elhelyezés
            float[] columnWidths = {3, 3, 4};
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(100);
            PdfPCell cell = new PdfPCell(new Phrase("Kapcsolatok"));
            cell.setBackgroundColor(BaseColor.BLUE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(3);
            table.addCell(cell);

            table.getDefaultCell().setBackgroundColor(BaseColor.DARK_GRAY);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("Vezetéknév");
            table.addCell("Keresztnév");
            table.addCell("E-mail cím");

            table.setHeaderRows(1);
            table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

            for (int counter = 1; counter <= data.size(); counter++) {
                Person actualPerson = data.get(counter - 1);
                table.addCell(actualPerson.getLastname());
                table.addCell(actualPerson.getFirstname());
                table.addCell(actualPerson.getEmail());
                

            }

            document.add(table);

            //Aláírás elhelyezése
            Chunk signature = new Chunk("\n\nKészítve a telefonkönyv alkalmazással");
            Paragraph base = new Paragraph(signature);
            document.add(base);
        } catch (Exception e) {
            System.out.println("Hiba a pdf készítésnél");
        }
        document.close();
    }

}
