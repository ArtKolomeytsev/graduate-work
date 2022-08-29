package ru.skypro.homework.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "userid")
    private Integer id;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    public enum RoleEnum {
        ADMIN, USER;
    }
    @Column(name = "Role")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    @OneToMany(mappedBy = "user")
    private List<Ads> adsList;

    @OneToMany(mappedBy = "user")
    private List<AdsComments> adsCommentsList;
}

