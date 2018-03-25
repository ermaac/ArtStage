package by.bsuir.spp.painters.model.repository;

import by.bsuir.spp.painters.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findById(Integer id);
    User findByLogin(String login);
}