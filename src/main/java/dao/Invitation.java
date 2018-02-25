package dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer project_id;
    private Integer senderPainter_infoId;
    private Integer recievePainter_infoId;
    private String description;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public Integer getSenderPainter_infoId() {
        return senderPainter_infoId;
    }

    public void setSenderPainter_infoId(Integer senderPainter_infoId) {
        this.senderPainter_infoId = senderPainter_infoId;
    }

    public Integer getRecievePainter_infoId() {
        return recievePainter_infoId;
    }

    public void setRecievePainter_infoId(Integer recievePainter_infoId) {
        this.recievePainter_infoId = recievePainter_infoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
