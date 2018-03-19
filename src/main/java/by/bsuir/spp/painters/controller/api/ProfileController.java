package by.bsuir.spp.painters.controller.api;

import by.bsuir.spp.painters.model.Profile;
import by.bsuir.spp.painters.model.repository.ProfileRepository;
import by.bsuir.spp.painters.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping("/profiles")
    public Iterable<Profile> getProfiles(){
        return profileService.findAllProfiles();
    }

    @PostMapping("/profiles")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile, UriComponentsBuilder ucBuilder){
        Profile createdProfile = profileService.createProfile(profile);
        if (createdProfile == null){
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<Profile>(profile, HttpStatus.OK);
    }

    @RequestMapping(value="/profiles/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Profile> deleteProfile(@PathVariable int id){
        Profile deletedProfile = profileService.deleteProfileWithId(id);
        if (deletedProfile == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Profile>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/profiles/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Profile> updateProfile(@PathVariable int id, @RequestBody Profile profile){
        Profile updatedProfile = profileService.updateProfile(id, profile);
        if (updatedProfile == null)
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<Profile>(updatedProfile, HttpStatus.OK);
    }
}
