package by.bsuir.spp.painters.controller.api;

import by.bsuir.spp.painters.model.Notification;
import by.bsuir.spp.painters.model.User;
import by.bsuir.spp.painters.model.repository.NotificationRepository;
import by.bsuir.spp.painters.model.repository.UserRepository;
import org.aspectj.weaver.ast.Not;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Date;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;


@RestController
@RequestMapping("/api")
public class NotificationController {
    private final NotificationRepository notificationRepository;
    @Autowired
    private UserRepository userRepository;

    public NotificationController(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("/notifications")
    public Iterable<Notification> getNotifications(){
       return notificationRepository.findAll();
    }

    @PostMapping("/notifications")
    public Notification createNotification(@RequestBody Notification notification, UriComponentsBuilder ucBuilder){
        notification.setDate(new Date(System.currentTimeMillis()));
        notificationRepository.save(notification);
        return notification;
    }

    @RequestMapping(value="/notifications/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Notification> deleteNotification(@PathVariable("id") int id){
        System.out.println(id);
        Optional<Notification> notification = notificationRepository.findById(id);
        if (notification != null){
            notificationRepository.delete(id);
        }
        return new ResponseEntity<Notification>(HttpStatus.NO_CONTENT);
    }
}
