package by.bsuir.spp.painters.model.repository;

import by.bsuir.spp.painters.model.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer>{

    @Query(value = "UPDATE project SET Name = ?2, State = ?3, Description = ?4 WHERE Id = ?1", nativeQuery = true)
    void updateById(int id, String name, String state, String description);

}