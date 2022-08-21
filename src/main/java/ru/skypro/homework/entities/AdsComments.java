package ru.skypro.homework.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "Ads_comment")
public class AdsComments {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(strategy = "uuid",name = "system-uuid")
    @Column(name = "id")
    private Integer idComment;

    @Column(name = "comment")
    private String text;

    @Column(name = "date_comm")
    private OffsetDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "messId")
    private Ads messages;

    @ManyToOne
    private User user;
}
