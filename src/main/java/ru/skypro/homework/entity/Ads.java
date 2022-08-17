package ru.skypro.homework.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Ads {

    @Id
    @GeneratedValue
    private Long id;

    private String authorFirstName;

    private String authorLastName;

    private String description;

    private String email;

    private String image;

    private String phone;

    private int pk;

    private int price;

    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ads ads = (Ads) o;
        return pk == ads.pk && price == ads.price && Objects.equals(id, ads.id) && Objects.equals(authorFirstName, ads.authorFirstName) && Objects.equals(authorLastName, ads.authorLastName) && Objects.equals(description, ads.description) && Objects.equals(email, ads.email) && Objects.equals(image, ads.image) && Objects.equals(phone, ads.phone) && Objects.equals(title, ads.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorFirstName, authorLastName, description, email, image, phone, pk, price, title);
    }

    @Override
    public String toString() {
        return "Ads{" +
                "id=" + id +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", phone='" + phone + '\'' +
                ", pk=" + pk +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}
