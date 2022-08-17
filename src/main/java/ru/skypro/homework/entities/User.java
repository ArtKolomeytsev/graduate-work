package ru.skypro.homework.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import ru.skypro.homework.dto.Role;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

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
    @Column(name = "Role")
    private Role role;


}