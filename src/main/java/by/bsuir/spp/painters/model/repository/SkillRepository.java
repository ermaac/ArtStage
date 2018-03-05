package by.bsuir.spp.painters.model.repository;

import by.bsuir.spp.painters.model.Skill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skill, Integer> {
    @Query(value = "SELECT s.Id, s.Name, s.Level FROM skill AS s RIGHT JOIN project_painter_info AS p WHERE p.Id = ?1", nativeQuery = true)
    Iterable<Skill> findAllByPainterInfoId(int id);
}
