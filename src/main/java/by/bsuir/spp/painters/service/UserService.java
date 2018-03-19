package by.bsuir.spp.painters.service;

import by.bsuir.spp.painters.model.User;
import by.bsuir.spp.painters.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userRepository.save(user);
    }
}
