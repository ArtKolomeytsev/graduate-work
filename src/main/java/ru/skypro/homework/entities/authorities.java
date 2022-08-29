package ru.skypro.homework.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "authorities")
public class authorities {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "authority")
    private String authority;
}
