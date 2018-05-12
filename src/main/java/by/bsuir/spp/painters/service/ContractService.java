package by.bsuir.spp.painters.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.*;

public class ContractService {
    private String documentFormat;
//    @Autowired
    DocxGenerator docxGenerator = new DocxGenerator();

    public ContractService(String format){
        documentFormat = format;
    }

    public byte[] generateContract(){
        byte[] contract = null;
        switch (documentFormat) {
            case "docx":
                contract = docxGenerator.generateDocument();
                break;
            case "pdf":
                break;
            case "csv":
                break;
        }
        return contract;
    }
}
