package by.bsuir.spp.painters.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "skill_painter_info", schema = "artstage_development", catalog = "")
public class SkillPainterInfo {
    private int id;
    private int painterInfoId;
    private int skillId;

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
    public int getPainterInfoId() {
        return painterInfoId;
    }

    public void setPainterInfoId(int painterInfoId) {
        this.painterInfoId = painterInfoId;
    }

    @Basic
    @Column(name = "Skill_Id")
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillPainterInfo that = (SkillPainterInfo) o;
        return id == that.id &&
                painterInfoId == that.painterInfoId &&
                skillId == that.skillId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, painterInfoId, skillId);
    }
}
