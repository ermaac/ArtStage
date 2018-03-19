package by.bsuir.spp.painters.service;

import by.bsuir.spp.painters.model.Ban;
import by.bsuir.spp.painters.model.repository.BanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class BanService {
    @Autowired
    BanRepository banRepository;
    public Ban createBan(Ban ban) {
        int userId = ban.getUserId();
        Ban existingBan = banRepository.findByUserId(userId);
        if (existingBan == null)
            return banRepository.save(ban);
        return null;
    }

    public Iterable<Ban> findAllBans(){
        return banRepository.findAll();
    }

    public Ban deleteBanWithId(int id){
        Ban ban = banRepository.findById(id);
        if (ban == null){
            return null;
        }
        banRepository.delete(id);
        return ban;
    }

    public Ban enableBan(int id){
        Ban currentBan = banRepository.findById(id);
        if (currentBan == null){
            return null;
        }
        currentBan.setBlockedTime(new Timestamp(System.currentTimeMillis()));
        return banRepository.save(currentBan);
    }

    public Ban disableBan(int id){
        Ban currentBan = banRepository.findById(id);
        if (currentBan == null){
            return null;
        }
        currentBan.setUnblockedTime(new Timestamp(System.currentTimeMillis()));
        return banRepository.save(currentBan);
    }
}
