package by.bsuir.spp.painters.model.repository;

import by.bsuir.spp.painters.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}