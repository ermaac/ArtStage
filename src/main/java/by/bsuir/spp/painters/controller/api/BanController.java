package by.bsuir.spp.painters.controller.api;

import by.bsuir.spp.painters.model.Address;
import by.bsuir.spp.painters.model.Ban;
import by.bsuir.spp.painters.model.repository.BanRepository;
import by.bsuir.spp.painters.service.BanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api")
public class BanController {

    @Autowired
    BanService banService;

    @GetMapping("/bans")
    public Iterable<Ban> getBans(){
        return banService.findAllBans();
    }

    @PostMapping("/bans")
    public ResponseEntity<Ban> createBan(@RequestBody Ban ban, UriComponentsBuilder ucBuilder){
        Ban createdBan = banService.createBan(ban);
        if (createdBan == null)
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<Ban>(ban, HttpStatus.OK);
    }

    @RequestMapping(value="/bans/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Ban> deleteBan(@PathVariable int id){
        Ban deletedBan = banService.deleteBanWithId(id);
        if (deletedBan == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Ban>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/bans/{id}/enable", method=RequestMethod.PUT)
    public ResponseEntity<Ban> enableBan(@PathVariable int id, @RequestBody Ban ban){
        Ban currentBan = banService.enableBan(id);
        if (currentBan == null)
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<Ban>(currentBan, HttpStatus.OK);
    }

    @RequestMapping(value="/bans/{id}/disable", method=RequestMethod.PUT)
    public ResponseEntity<Ban> disableBan(@PathVariable int id, @RequestBody Ban ban){
        Ban currentBan = banService.disableBan(id);
        if (currentBan == null)
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<Ban>(currentBan, HttpStatus.OK);
    }
}
