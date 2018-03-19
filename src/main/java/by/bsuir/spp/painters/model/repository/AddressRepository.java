package by.bsuir.spp.painters.model.repository;

import by.bsuir.spp.painters.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
    public Address findById(int id);
    public Address findByProfileId(int id);
}
