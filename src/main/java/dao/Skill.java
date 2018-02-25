package dao;

import javax.persistence.*;
import javax.swing.*;
import java.util.Set;

public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String level;
    @ManyToMany
    @JoinTable(name="skill_painterInfo")
    private Set<PainterInfo> painters;
}
