package by.bsuir.spp.painters.model.repository;

        import by.bsuir.spp.painters.model.Request;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Integer> {

   /* @Query("FROM request where User_Id = ?1")
    List<Request> findAllByUserId(int id);*/

   /* @Query("UPDATE request SET Status = ?2 WHERE Id = ?1")
    void updateStatusById(int id, String status);*/
}
