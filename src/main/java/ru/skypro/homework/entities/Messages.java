package ru.skypro.homework.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(strategy = "uuid", name = "system-uuid")
    @Column(name="id")
    private String messId;

    @Column(name="message")
    private String  messageData;

    @Column(name = "date_mess")
    @CreatedDate
    private Date dateMess;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;


}
