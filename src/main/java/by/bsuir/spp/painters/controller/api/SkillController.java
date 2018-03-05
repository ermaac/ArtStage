package by.bsuir.spp.painters.controller.api;
import by.bsuir.spp.painters.model.Skill;
import by.bsuir.spp.painters.model.repository.SkillRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SkillController {
    private final SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {

        this.skillRepository = skillRepository;
    }

    @GetMapping("/skills")
    public Iterable<Skill> getSkills() {
        return skillRepository.findAll();
    }

    @PostMapping("/skill")
    public Skill createSkill(@RequestParam String name, @RequestParam Short level){
        Skill skill = new Skill();
        skill.setName(name);
        skill.setLevel(level);
        skill = skillRepository.save(skill);
        return skill;
    }

    @DeleteMapping("/skill")
    public void deleteSkill(@RequestParam int id){
        skillRepository.delete(id);
    }


}
