package by.bsuir.spp.painters.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Attachment {
    private int id;
    private Integer requestId;
    private String attachmentPath;

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
    @Column(name = "Request_Id")
    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    @Basic
    @Column(name = "Attachment_Path")
    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attachment that = (Attachment) o;
        return id == that.id &&
                Objects.equals(requestId, that.requestId) &&
                Objects.equals(attachmentPath, that.attachmentPath);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, requestId, attachmentPath);
    }
}
