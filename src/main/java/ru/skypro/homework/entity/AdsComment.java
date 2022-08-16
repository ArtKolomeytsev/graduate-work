package ru.skypro.homework.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class AdsComment {

    @Id
    @GeneratedValue
    private Long id;

    private String author;

    private String createdAt;

    private int pk;

    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdsComment that = (AdsComment) o;
        return pk == that.pk && Objects.equals(id, that.id) && Objects.equals(author, that.author) && Objects.equals(createdAt, that.createdAt) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, createdAt, pk, text);
    }

    @Override
    public String toString() {
        return "AdsComment{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", pk=" + pk +
                ", text='" + text + '\'' +
                '}';
    }
}
