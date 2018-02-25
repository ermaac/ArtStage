package dao;

import javax.persistence.*;
import java.util.Set;

public class PainterInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name="profile_Id")
    private Profile profile;
    private Float rate;
    private Integer ratesCount;
    private Integer dealesCount;
    @ManyToMany(mappedBy = "painters")
    private Set<Skill> skills;
}
