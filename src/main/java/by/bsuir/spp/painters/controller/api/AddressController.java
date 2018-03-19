package by.bsuir.spp.painters.controller.api;

import by.bsuir.spp.painters.model.Address;
import by.bsuir.spp.painters.model.Profile;
import by.bsuir.spp.painters.model.repository.AddressRepository;
import by.bsuir.spp.painters.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class AddressController {
    @Autowired
    AddressService addressService;
//    @GetMapping("/addresses")
//    public Iterable<Address> getAddresses(){
//        return addressRepository.findAll();
//    }

    @PostMapping("/addresses")
    public ResponseEntity<Address> createAddress(@RequestBody Address address, UriComponentsBuilder ucBuilder){
        Address createdAddress = addressService.createAddress(address);
        if (createdAddress == null)
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

    @RequestMapping(value="/addresses/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Address> deleteAddress(@PathVariable int id){
        Address deletedAddress = addressService.deleteAddressWithId(id);
        if (deletedAddress == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/addresses/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Address> updateAddress(@PathVariable int id, @RequestBody Address address){
        Address updatedAddress = addressService.updateAddress(id, address);
        if (updatedAddress == null)
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<Address>(updatedAddress, HttpStatus.OK);
    }

}
