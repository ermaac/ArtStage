package by.bsuir.spp.painters.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Image {
    private int id;
    private Integer projectId;
    private Integer painterId;
    private byte[] image;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Project_Id")
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "Painter_Id")
    public Integer getPainterId() {
        return painterId;
    }

    public void setPainterId(Integer painterId) {
        this.painterId = painterId;
    }

    @Basic
    @Column(name = "Image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image1 = (Image) o;
        return id == image1.id &&
                Objects.equals(projectId, image1.projectId) &&
                Objects.equals(painterId, image1.painterId) &&
                Arrays.equals(image, image1.image);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, projectId, painterId);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
