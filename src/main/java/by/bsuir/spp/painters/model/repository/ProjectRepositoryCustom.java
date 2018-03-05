package by.bsuir.spp.painters.model.repository;

import by.bsuir.spp.painters.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.sql.SQLException;

public interface ProjectRepositoryCustom {

    void updateById(Project project) throws SQLException;

}