package by.bsuir.spp.painters.model;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer project_id;
    @ManyToOne
    @JoinColumn(name = "PainterInfo_Id")
    private PainterInfo painterInfo;
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PainterInfo getPainterInfo() {
        return painterInfo;
    }

    public void setPainter_id(PainterInfo painterInfo) {
        this.painterInfo = painterInfo;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
