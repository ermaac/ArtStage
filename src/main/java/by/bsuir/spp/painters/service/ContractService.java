package by.bsuir.spp.painters.service;

import by.bsuir.spp.painters.service.context.ContractContext;
import org.docx4j.jaxb.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.*;

public class ContractService {
    private String documentFormat;
//    @Autowired
    DocxGenerator docxGenerator;
    PdfGenerator pdfGenerator;

    public ContractService(String format){
        documentFormat = format;
        Context context = new ContractContext("Vlad Ermolov", "", "");
        docxGenerator = new DocxGenerator(context);
        pdfGenerator = new PdfGenerator(docxGenerator);
    }

    public byte[] generateContract(){
        byte[] contract = null;
        switch (documentFormat) {
            case "docx":
                contract = docxGenerator.generateDocument();
                break;
            case "pdf":
                contract = pdfGenerator.generateDocument();
                break;
            case "csv":
                break;
        }
        return contract;
    }
}
