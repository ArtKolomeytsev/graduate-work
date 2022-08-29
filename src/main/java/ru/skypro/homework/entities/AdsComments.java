package ru.skypro.homework.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.OffsetDateTime;


@Entity
@Table(name = "ads_comment")
@Data
public class AdsComments {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer idComment;

    @Column(name = "comment")
    private String text;

    @CreatedDate
    @Column(name = "date_comm")
    private OffsetDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "messId")
    private Ads messages;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users user;
}
