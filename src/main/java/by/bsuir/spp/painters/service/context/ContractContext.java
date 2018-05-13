package by.bsuir.spp.painters.service.context;

import org.docx4j.jaxb.Context;

public class ContractContext extends Context {

    public String getPainterName() {

        return painterName;
    }

    public String getCustomerName() {
        return customerName;
    }

    private String painterName;
    private String customerName;
    private String pictureName;

    public ContractContext(String painterName, String customerName, String pictureName) {
        this.painterName = painterName;
        this.customerName = customerName;
        this.pictureName = pictureName;
    }

    public String getPictureName() {
        return pictureName;
    }
}
