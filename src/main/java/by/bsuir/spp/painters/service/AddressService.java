package by.bsuir.spp.painters.service;

import by.bsuir.spp.painters.model.Address;
import by.bsuir.spp.painters.model.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public Address save(Address address){
        if (validAddress(address))
           return addressRepository.save(address);
        return null;
    }

    public Address deleteAddressWithId(int id){
        Address address = addressRepository.findById(id);
        if (address == null)
            return null;
        addressRepository.delete(id);
        return address;
    }

    public Address createAddress(Address address){
        int prodileId = address.getProfileId();
        Address existingAddress = addressRepository.findByProfileId(prodileId);
        if (existingAddress == null)
            return addressRepository.save(address);
        return null;
    }

    public Address updateAddress(int id, Address address){
        Address currentAddress = addressRepository.findById(id);
        if (currentAddress == null){
            return null;
        }
        currentAddress.setProfileId(address.getProfileId());
        currentAddress.setContry(address.getContry());
        currentAddress.setRegion(address.getRegion());
        currentAddress.setCity(address.getCity());
        currentAddress.setStreet(address.getStreet());
        currentAddress.setHouseNumber(address.getHouseNumber());
        currentAddress.setProfileId(address.getProfileId());
        return addressRepository.save(currentAddress);
    }

    private boolean validAddress(Address address){
        if (address.getContry() == null)
            return false;
        return true;
    }
}
