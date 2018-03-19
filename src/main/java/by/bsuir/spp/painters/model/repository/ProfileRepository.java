package by.bsuir.spp.painters.model.repository;

import by.bsuir.spp.painters.model.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
    public Profile findById(int id);
    public Profile findByUserId(int id);
}
