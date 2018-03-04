package by.bsuir.spp.painters.controller.api;

import by.bsuir.spp.painters.model.Address;
import by.bsuir.spp.painters.model.Profile;
import by.bsuir.spp.painters.model.repository.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class AddressController {
    private AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository){
        this.addressRepository =addressRepository;
    }


    @GetMapping("/addresses")
    public Iterable<Address> getAddresses(){
        return addressRepository.findAll();
    }

    @PostMapping("/addresses")
    public ResponseEntity<Address> createAddress(@RequestBody Address address, UriComponentsBuilder ucBuilder){
        addressRepository.save(address);
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

    @RequestMapping(value="/addresses/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Address> deleteAddress(@PathVariable int id){
        Address address = addressRepository.findById(id);
        if (address == null){
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
        addressRepository.delete(id);
        return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/addresses/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Address> updateAddress(@PathVariable int id, @RequestBody Address address){
        Address currentAddress = addressRepository.findById(id);
        if (address == null){
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
        currentAddress.setProfileId(address.getProfileId());
        currentAddress.setContry(address.getContry());
        currentAddress.setRegion(address.getRegion());
        currentAddress.setCity(address.getCity());
        currentAddress.setStreet(address.getStreet());
        currentAddress.setHouseNumber(address.getHouseNumber());
        currentAddress.setProfileId(address.getProfileId());
        addressRepository.save(currentAddress);
        return new ResponseEntity<Address>(currentAddress, HttpStatus.OK);
    }

}
