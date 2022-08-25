package ru.skypro.homework.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Ads")
public class Ads {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(strategy = "uuid", name = "system-uuid")
    @Column(name="id")
    private Integer messId;

    @Column(name = "Price")
    private Integer price;

    @Column(name = "Description")
    private String description;

    @Column(name = "Title")
    private String title;

    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "Ads")
    private List<AdsComments> adsComments;


}
