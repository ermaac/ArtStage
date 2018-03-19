package by.bsuir.spp.painters.service;

import by.bsuir.spp.painters.model.Profile;
import by.bsuir.spp.painters.model.repository.ProfileRepository;
import by.bsuir.spp.painters.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    UserRepository userRepository;

    public Profile save(Profile profile){
        if (profileValid(profile))
            return profileRepository.save(profile);
        return null;
    }

    public Profile deleteProfileWithId(int id){
        Profile profile = profileRepository.findById(id);
        if (profile == null){
            return null;
        }
        profileRepository.delete(id);
        return profile;
    }

    public Profile updateProfile(int id, Profile profile){
        Profile currentProfile = profileRepository.findById(id);
        if (profile == null){
            return null;
        }
        currentProfile.setBirthday(profile.getBirthday());
        currentProfile.setFirstname(profile.getFirstname());
        currentProfile.setLastname(profile.getLastname());
        currentProfile.setPhoneNumber(profile.getPhoneNumber());
        return save(currentProfile);
    }

    public Profile createProfile(Profile profile){
        int userId = profile.getUserId();
        Profile existingProfile = profileRepository.findByUserId(userId);
        if (existingProfile == null)
            return save(profile);
        return null;
    }

    public Iterable<Profile> findAllProfiles(){
        return profileRepository.findAll();
    }

    public boolean profileValid(Profile profile){
        Integer userId = profile.getUserId();
        if (userRepository.findById(userId) == null)
            return false;
        if (profile.getFirstname().isEmpty())
            return false;
        if (profile.getLastname().isEmpty())
            return false;
        return true;
    }
}
