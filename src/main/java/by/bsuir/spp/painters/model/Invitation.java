package by.bsuir.spp.painters.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Invitation {
    private int id;
    private Integer projectId;
    private Integer senderPaiterInfoId;
    private Integer recieverPainterInfoId;
    private String description;
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "Sender_Paiter_Info_Id")
    public Integer getSenderPaiterInfoId() {
        return senderPaiterInfoId;
    }

    public void setSenderPaiterInfoId(Integer senderPaiterInfoId) {
        this.senderPaiterInfoId = senderPaiterInfoId;
    }

    @Basic
    @Column(name = "Reciever_Painter_Info_Id")
    public Integer getRecieverPainterInfoId() {
        return recieverPainterInfoId;
    }

    public void setRecieverPainterInfoId(Integer recieverPainterInfoId) {
        this.recieverPainterInfoId = recieverPainterInfoId;
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
    @Column(name = "Date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invitation that = (Invitation) o;
        return id == that.id &&
                Objects.equals(projectId, that.projectId) &&
                Objects.equals(senderPaiterInfoId, that.senderPaiterInfoId) &&
                Objects.equals(recieverPainterInfoId, that.recieverPainterInfoId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, projectId, senderPaiterInfoId, recieverPainterInfoId, description, date);
    }
}
