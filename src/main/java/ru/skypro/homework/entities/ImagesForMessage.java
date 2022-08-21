package ru.skypro.homework.entities;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "images_for_message")
public class ImagesForMessage {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(strategy = "uuid", name = "system-uuid")
    @Column(name="id")
    private String imgId;

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
