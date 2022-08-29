package ru.skypro.homework.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ads")
@Data
public class Ads {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer messId;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;

    @Column(name = "date_mess")
    @CreatedDate
    private Date dateMess;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users user;

    @OneToMany(mappedBy = "messages")
    private List<AdsComments> adsComments;

    @OneToOne(mappedBy = "messages")
    private AdvertImages imagesForMessages;


}
