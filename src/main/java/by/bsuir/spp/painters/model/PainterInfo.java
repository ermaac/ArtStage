package by.bsuir.spp.painters.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "painter_info", schema = "artstage_development", catalog = "")
public class PainterInfo {
    private int id;
    private int profileId;
    private Double rate;
    private Integer ratesCount;
    private Integer dealsCount;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Profile_Id")
    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    @Basic
    @Column(name = "Rate")
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "Rates_Count")
    public Integer getRatesCount() {
        return ratesCount;
    }

    public void setRatesCount(Integer ratesCount) {
        this.ratesCount = ratesCount;
    }

    @Basic
    @Column(name = "Deals_count")
    public Integer getDealsCount() {
        return dealsCount;
    }

    public void setDealsCount(Integer dealsCount) {
        this.dealsCount = dealsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PainterInfo that = (PainterInfo) o;
        return id == that.id &&
                profileId == that.profileId &&
                Objects.equals(rate, that.rate) &&
                Objects.equals(ratesCount, that.ratesCount) &&
                Objects.equals(dealsCount, that.dealsCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, profileId, rate, ratesCount, dealsCount);
    }
}
