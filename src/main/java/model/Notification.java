package model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Notification {
    private Integer id;
    private String text;
    private Integer sender_id;
    private Integer receiver_id;
    private Date date;
}
