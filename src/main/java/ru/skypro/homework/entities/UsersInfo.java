package ru.skypro.homework.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users_info")
public class UsersInfo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
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

