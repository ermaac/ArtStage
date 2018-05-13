package by.bsuir.spp.painters.service;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PdfGenerator {
    private DocxGenerator docxGenerator;
    public PdfGenerator(DocxGenerator docxGenerator) {
        this.docxGenerator = docxGenerator;
    }

    public byte[] generateDocument(){
        ByteOutputStream outputStream = new ByteOutputStream();
        XWPFDocument document = null;
        InputStream inputStream = new ByteArrayInputStream(docxGenerator.generateDocument());
        try {
            document = new XWPFDocument(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PdfOptions options = PdfOptions.create();
        try {
            PdfConverter.getInstance().convert(document, outputStream, options);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.getBytes();
    }
}
