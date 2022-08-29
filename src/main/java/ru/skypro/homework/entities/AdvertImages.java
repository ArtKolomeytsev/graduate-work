package ru.skypro.homework.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "images_for_message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertImages {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer imgId;

    @Column(name = "media_type")
    private String mediaType;

    @Lob
    @Column(name = "content")
    private byte[] content;

    @OneToOne
    @JoinColumn(name = "messId")
    private Ads messages;
}
