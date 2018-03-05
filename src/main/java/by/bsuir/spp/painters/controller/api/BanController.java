package by.bsuir.spp.painters.controller.api;

import by.bsuir.spp.painters.model.Address;
import by.bsuir.spp.painters.model.Ban;
import by.bsuir.spp.painters.model.repository.BanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api")
public class BanController {
    private BanRepository banRepository;

    public BanController(BanRepository banRepository){
        this.banRepository = banRepository;
    }

    @GetMapping("/bans")
    public Iterable<Ban> getBans(){
        return banRepository.findAll();
    }

    @PostMapping("/bans")
    public ResponseEntity<Ban> createBan(@RequestBody Ban ban, UriComponentsBuilder ucBuilder){
        banRepository.save(ban);
        return new ResponseEntity<Ban>(ban, HttpStatus.OK);
    }

    @RequestMapping(value="/bans/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Ban> deleteBan(@PathVariable int id){
        Ban ban = banRepository.findById(id);
        if (ban == null){
            return new ResponseEntity<Ban>(HttpStatus.NOT_FOUND);
        }
        banRepository.delete(id);
        return new ResponseEntity<Ban>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/bans/{id}/enable", method=RequestMethod.PUT)
    public ResponseEntity<Ban> enableBan(@PathVariable int id, @RequestBody Ban ban){
        Ban currentBan = banRepository.findById(id);
        if (ban == null){
            return new ResponseEntity<Ban>(HttpStatus.NOT_FOUND);
        }
        currentBan.setUserId(ban.getUserId());
        currentBan.setDescription(ban.getDescription());
        currentBan.setBlockedTime(new Timestamp(System.currentTimeMillis()));
        banRepository.save(currentBan);
        return new ResponseEntity<Ban>(currentBan, HttpStatus.OK);
    }

    @RequestMapping(value="/bans/{id}/disable", method=RequestMethod.PUT)
    public ResponseEntity<Ban> disableBan(@PathVariable int id, @RequestBody Ban ban){
        Ban currentBan = banRepository.findById(id);
        if (ban == null){
            return new ResponseEntity<Ban>(HttpStatus.NOT_FOUND);
        }
        currentBan.setUserId(ban.getUserId());
        currentBan.setDescription(ban.getDescription());
        currentBan.setUnblockedTime(new Timestamp(System.currentTimeMillis()));
        banRepository.save(currentBan);
        return new ResponseEntity<Ban>(currentBan, HttpStatus.OK);
    }
}
