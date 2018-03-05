package by.bsuir.spp.painters.controller.api;
import by.bsuir.spp.painters.model.Request;
import by.bsuir.spp.painters.model.repository.RequestRepository;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;

@RestController
@RequestMapping("/api")
public class RequestController {
    private final RequestRepository requestRepository;

    public RequestController(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

   /* @GetMapping("/requests")
    public Iterable<Request> getRequest(int id) {
        return requestRepository.findAllByUserId(id);
    }*/
    @PostMapping("/requests")
    public Request createRequest(int userId, String description, Date date)
    {
        Request request = new Request();
        request.setUserId(userId);
        request.setDate(date);
        request.setDescription(description);
        request.setStatus("Not Processed");
        request = requestRepository.save(request);
        return request;
    }
    @DeleteMapping("/requests")
    public void deleteRequest(int id)
    {
        requestRepository.delete(id);
    }

   /* @PutMapping
    public void updateRequest(int id, String status)
    {
        requestRepository.updateStatusById(id, status);
    }
*/

}
