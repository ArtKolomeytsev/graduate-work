package ru.skypro.homework.entities;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "images_for_message")
@Data
public class ImagesForMessage {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer imgId;

    @Column(name = "media_type")
    private String mediaType;

    @Lob
    @Column(name = "content")
    private byte[] content;

    @Column(name = "date_img")
    @CreatedDate
    private Date dateImg;

    @ManyToOne
    @JoinColumn(name = "messId")
    private Ads messages;
}
