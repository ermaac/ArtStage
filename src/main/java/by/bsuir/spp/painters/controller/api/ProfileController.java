package by.bsuir.spp.painters.controller.api;

import by.bsuir.spp.painters.model.Profile;
import by.bsuir.spp.painters.model.repository.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfileController {
    private ProfileRepository profileRepository;
    public ProfileController(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @GetMapping("/profiles")
    public Iterable<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    @PostMapping("/profiles")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile, UriComponentsBuilder ucBuilder){
        profileRepository.save(profile);
        return new ResponseEntity<Profile>(profile, HttpStatus.OK);
    }

    @RequestMapping(value="/profiles/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Profile> deleteProfile(@PathVariable int id){
        Profile profile = profileRepository.findById(id);
        if (profile == null){
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }
        profileRepository.delete(id);
        return new ResponseEntity<Profile>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/profiles/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Profile> updateProfile(@PathVariable int id, @RequestBody Profile profile){
        Profile currentProfile = profileRepository.findById(id);
        if (profile == null){
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }
        currentProfile.setBirthday(profile.getBirthday());
        currentProfile.setFirstname(profile.getFirstname());
        currentProfile.setLastname(profile.getLastname());
        currentProfile.setPhoneNumber(profile.getPhoneNumber());
        profileRepository.save(currentProfile);
        return new ResponseEntity<Profile>(currentProfile, HttpStatus.OK);
    }
}
