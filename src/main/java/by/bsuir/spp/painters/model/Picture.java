package by.bsuir.spp.painters.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Picture {
    private int id;
    private Integer painterInfoId;
    private String name;
    private String price;
    private byte isTrade;
    private String description;
    private Integer projectId;
    private Integer attachmentId;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Painter_Info_Id")
    public Integer getPainterInfoId() {
        return painterInfoId;
    }

    public void setPainterInfoId(Integer painterInfoId) {
        this.painterInfoId = painterInfoId;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Is_Trade")
    public byte getIsTrade() {
        return isTrade;
    }

    public void setIsTrade(byte isTrade) {
        this.isTrade = isTrade;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "Attachment_Id")
    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture picture = (Picture) o;
        return id == picture.id &&
                isTrade == picture.isTrade &&
                Objects.equals(painterInfoId, picture.painterInfoId) &&
                Objects.equals(name, picture.name) &&
                Objects.equals(price, picture.price) &&
                Objects.equals(description, picture.description) &&
                Objects.equals(projectId, picture.projectId) &&
                Objects.equals(attachmentId, picture.attachmentId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, painterInfoId, name, price, isTrade, description, projectId, attachmentId);
    }
}
