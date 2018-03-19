package by.bsuir.spp.painters.controller.api;
import by.bsuir.spp.painters.model.User;
import by.bsuir.spp.painters.model.repository.UserRepository;
import by.bsuir.spp.painters.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
        userService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}

