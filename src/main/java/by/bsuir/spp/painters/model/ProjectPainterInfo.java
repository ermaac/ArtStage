package by.bsuir.spp.painters.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "project_painter_info", schema = "artstage_development", catalog = "")
public class ProjectPainterInfo {
    private int id;
    private int idPainterInfo;
    private int idProject;

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
    @Column(name = "Id_Painter_Info")
    public int getIdPainterInfo() {
        return idPainterInfo;
    }

    public void setIdPainterInfo(int idPainterInfo) {
        this.idPainterInfo = idPainterInfo;
    }

    @Basic
    @Column(name = "Id_Project")
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectPainterInfo that = (ProjectPainterInfo) o;
        return id == that.id &&
                idPainterInfo == that.idPainterInfo &&
                idProject == that.idProject;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idPainterInfo, idProject);
    }
}
