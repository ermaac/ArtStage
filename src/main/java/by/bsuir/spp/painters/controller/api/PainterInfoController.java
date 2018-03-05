package by.bsuir.spp.painters.controller.api;

import by.bsuir.spp.painters.model.PainterInfo;
import by.bsuir.spp.painters.model.Skill;
import by.bsuir.spp.painters.model.SkillPainterInfo;
import by.bsuir.spp.painters.model.repository.PainterInfoRepository;
import by.bsuir.spp.painters.model.repository.SkillPainterInfoRepository;
import by.bsuir.spp.painters.model.repository.SkillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api")
public class PainterInfoController {
    private final PainterInfoRepository painterInfoRepository;
    private final SkillRepository skillRepository;
    private final SkillPainterInfoRepository skillPainterInfoRepository;
    public  PainterInfoController(PainterInfoRepository painterInfoRepository, SkillRepository skillRepository,
                                  SkillPainterInfoRepository skillPainterInfoRepository)
    {
        this.painterInfoRepository = painterInfoRepository;
        this.skillRepository = skillRepository;
        this.skillPainterInfoRepository = skillPainterInfoRepository;
    }

    @GetMapping("/painters")
    public Iterable<PainterInfo> getAllPainters(){
        return painterInfoRepository.findAll();
    }

    @GetMapping("/painter")
    public PainterInfo getPainterInfo(int painterId)
    {
        PainterInfo painterInfo = painterInfoRepository.findOne(painterId);
        //Iterable<Skill> skills= skillRepository.findAllByPainterInfoId(painterId);
        return painterInfo;
    }

    @PostMapping("/painter")
    public PainterInfo createPainterInfo(int profileId, int[] skills)
    {
        PainterInfo painter = new PainterInfo();
        painter.setProfileId(profileId);
        painter.setDealsCount(0);
        painter.setRate(0.0);
        painter.setRatesCount(0);
        painter = painterInfoRepository.save(painter);
        List<SkillPainterInfo> skillPainterInfos = new ArrayList<SkillPainterInfo>();
        for (int i: skills) {
            SkillPainterInfo skillPainter = new SkillPainterInfo();
            skillPainter.setPainterInfoId(painter.getId());
            skillPainter.setSkillId(i);
            skillPainterInfos.add(skillPainter);
        }
        skillPainterInfoRepository.save(skillPainterInfos);
        return painter;
    }
    @DeleteMapping("/painter")
    public void deletePainterInfo(int id)
    {
        painterInfoRepository.delete(id);
    }
   /* @PutMapping("/painter")
    public PainterInfo updatePainterInfo(PainterInfo painterInfo)
    {
        painterInfoRepository.updateById(painterInfo.getId(), painterInfo.getRate(), painterInfo.getRatesCount(),
                painterInfo.getDealsCount());
        return painterInfo;
    }*/
}
