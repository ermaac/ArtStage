package by.bsuir.spp.painters.controller.api;
import by.bsuir.spp.painters.model.User;
import by.bsuir.spp.painters.model.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestParam String login, @RequestParam String password){
        User user = new User();
        user.setLogin(login);
        user.setPasswordHash(password);
        user.setRole("user");
        userRepository.save(user);
        return user;
    }
}

