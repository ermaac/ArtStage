package by.bsuir.spp.painters.service;

import by.bsuir.spp.painters.model.User;
import by.bsuir.spp.painters.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(int id){
        return userRepository.findById(id);
    }

    public User save(User user){
        if (isValid(user)){
            userRepository.save(user);
            return user;
        }
        return null;
    }

    public User createUser(User user) {
        user.setRole("user");
        return save(user);
    }

    private boolean isValid(User user){
        if (StringUtils.isEmpty(user.getLogin())){
            return false;
        }
        if (StringUtils.isEmpty(user.getRole())){
            return false;
        }
        if (StringUtils.isEmpty(user.getPasswordHash())){
            return false;
        }
        return true;
    }
}