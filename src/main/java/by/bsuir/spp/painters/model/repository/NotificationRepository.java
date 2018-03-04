package by.bsuir.spp.painters.model.repository;

import by.bsuir.spp.painters.model.Notification;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {
    Optional<Notification> findById(int id);
}
