package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer project_id;
    @OneToOne
    @JoinColumn(name = "SenderPainter_Id")
    private PainterInfo senderPainterInfo;
    @OneToOne
    @JoinColumn(name = "RecieverPainter_Id")
    private PainterInfo recieverPainterInfo;
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

    public PainterInfo getSenderPainterInfo() {
        return senderPainterInfo;
    }

    public void setSenderPainterInfo(PainterInfo senderPainterInfo) {
        this.senderPainterInfo = senderPainterInfo;
    }

    public PainterInfo getRecieverPainterInfo() {
        return recieverPainterInfo;
    }

    public void setRecieverPainterInfo(PainterInfo recieverPainterInfo) {
        this.recieverPainterInfo= recieverPainterInfo;
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
