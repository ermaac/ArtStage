package dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer project_id;
    private Integer painter_id;
    private Boolean image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPainter_id() {
        return painter_id;
    }

    public void setPainter_id(Integer painter_id) {
        this.painter_id = painter_id;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public Boolean getImage() {
        return image;
    }

    public void setImage(Boolean image) {
        this.image = image;
    }
}
