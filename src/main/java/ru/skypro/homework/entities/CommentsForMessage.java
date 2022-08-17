package ru.skypro.homework.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "comments_for_message")
public class CommentsForMessage {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(strategy = "uuid",name = "system-uuid")
    @Column(name = "id")
    private String idComment;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date_comm")
    @CreatedDate
    private Date dateImg;

    @ManyToOne
    @JoinColumn(name = "messId")
    private Messages messages;
}
