package dao;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer user_id;
    private Date blocked_time;
    private Date unblocked_time;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
