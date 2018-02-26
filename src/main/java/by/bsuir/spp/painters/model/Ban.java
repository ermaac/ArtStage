package by.bsuir.spp.painters.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="User_Id")
    private User user;
    private Date blocked_time;
    private Date unblocked_time;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBlocked_time() {
        return blocked_time;
    }

    public void setBlocked_time(Date blocked_time) {
        this.blocked_time = blocked_time;
    }

    public Date getUnblocked_time() {
        return unblocked_time;
    }

    public void setUnblocked_time(Date unblocked_time) {
        this.unblocked_time = unblocked_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
