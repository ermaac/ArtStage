package by.bsuir.spp.painters.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Ban {
    private int id;
    private int userId;
    private Timestamp blockedTime;
    private Timestamp unblockedTime;
    private String description;

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
    @Column(name = "User_Id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Blocked_Time")
    public Timestamp getBlockedTime() {
        return blockedTime;
    }

    public void setBlockedTime(Timestamp blockedTime) {
        this.blockedTime = blockedTime;
    }

    @Basic
    @Column(name = "Unblocked_Time")
    public Timestamp getUnblockedTime() {
        return unblockedTime;
    }

    public void setUnblockedTime(Timestamp unblockedTime) {
        this.unblockedTime = unblockedTime;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ban ban = (Ban) o;
        return id == ban.id &&
                userId == ban.userId &&
                Objects.equals(blockedTime, ban.blockedTime) &&
                Objects.equals(unblockedTime, ban.unblockedTime) &&
                Objects.equals(description, ban.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, blockedTime, unblockedTime, description);
    }
}
