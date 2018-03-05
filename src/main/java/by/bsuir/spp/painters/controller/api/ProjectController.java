package by.bsuir.spp.painters.controller.api;

import by.bsuir.spp.painters.model.Project;
import by.bsuir.spp.painters.model.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/projects")
    public Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    @GetMapping("/project")
    public Project getProject(int id) {
        return projectRepository.findOne(id);
    }
    @PostMapping("/project")
    public Project createProject(@RequestParam String name, @RequestParam String state, @RequestParam String description)
    {
        Project project = new Project();
        project.setName(name);
        project.setState(state);
        project.setDescription(description);
        projectRepository.save(project);
        return project;
    }

    @DeleteMapping("/project")
    public void deleteProject(int id)
    {
        projectRepository.delete(id);
    }

  /*  @PutMapping
    public void updateProject(int id, String name, String state, String description)
    {
       projectRepository.updateById(id, name, state, description);
    }
    */
}
