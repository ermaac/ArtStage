package by.bsuir.spp.painters.model.repository;

import by.bsuir.spp.painters.model.PainterInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PainterInfoRepository extends CrudRepository<PainterInfo, Integer> {

   /* @Query("UPDATE painter_info SET Rate = ?2, Rates_Count = ?3, Deals_count = ?4  WHERE Id = ?1")
    void updateById(int id, double rate, int ratesCount, int dealsCount);*/
}
