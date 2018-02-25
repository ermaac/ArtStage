package dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer painter_info_id;
    private String name;
    private Float price;
    private Boolean is_trade;
    private String description;
    private Integer project_id;
    private Integer attachement_id;
}
