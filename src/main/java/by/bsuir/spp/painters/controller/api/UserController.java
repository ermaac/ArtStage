package by.bsuir.spp.painters.controller.api;
import by.bsuir.spp.painters.dto.UserDto;
import by.bsuir.spp.painters.model.User;
import by.bsuir.spp.painters.model.repository.UserRepository;
import by.bsuir.spp.painters.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto, UriComponentsBuilder ucBuilder){
        User user = convertToEntity(userDto);
        User createdUser = userService.createUser(user);
        UserDto createdUserDto = convertToDto(createdUser);
        if (createdUser == null){
            return new ResponseEntity<UserDto>(createdUserDto, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<UserDto>(createdUserDto, HttpStatus.OK);
    }

    @GetMapping("/account")
    public ResponseEntity<User> getAccount(){
        User currentUser = userService.getCurrentUser();
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    private User convertToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setPasswordHash(bCryptPasswordEncoder.encode(userDto.getPassword()));
        return user;
    }

    private UserDto convertToDto(User user){
        return modelMapper.map(user, UserDto.class);
    }
}

