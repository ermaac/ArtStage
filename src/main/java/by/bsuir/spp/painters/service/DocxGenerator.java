package by.bsuir.spp.painters.service;

import by.bsuir.spp.painters.model.User;
import by.bsuir.spp.painters.service.context.ContractContext;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.docx4j.jaxb.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.wickedsource.docxstamper.DocxStamper;
import org.wickedsource.docxstamper.DocxStamperConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DocxGenerator {
    private DocxStamper stamper;
    private InputStream inputStream;
    private OutputStream outputStream;
    private Context context;
//    @Value(value = "classpath:documentTemplates/contract.doc")
//    private Resource template;
//    @Autowired
//    private ResourceLoader resourceLoader;

    public DocxGenerator(Context context){

        this.context = context;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        inputStream = classLoader.getResourceAsStream("documentTemplates/contract.docx");
        outputStream = new ByteOutputStream();
        stamper = new DocxStamperConfiguration().build();
    }

    public byte[] generateDocument(){
        stamper.stamp(inputStream, context, outputStream);
        ByteOutputStream documentStream = (ByteOutputStream)outputStream;
        byte[] document = documentStream.getBytes();
        return document;
    }
}
