package by.bsuir.spp.painters.controller.api;

import by.bsuir.spp.painters.service.ContractService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

@RestController
@RequestMapping("/api")
public class ContractController {

    @GetMapping("/contracts.{format}")
    public void createProfile(HttpServletResponse response, @PathVariable("format") String format,
                              @PathVariable int painterId, @PathVariable int customerId, @PathVariable int pictureId){
        ContractService contractService = new ContractService(format);
        byte[] document = contractService.generateContract();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"contract.docx\"");
        try {
            response.getOutputStream().write(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
