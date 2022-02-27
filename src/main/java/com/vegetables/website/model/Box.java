package com.vegetables.website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "boxes")
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotEmpty
    private String boxName;

    @Column
    @NotEmpty
    private float price;

    @Column
    @NotEmpty
    private String boxDescription;

    @Column
    @NotEmpty
    private String imagePath;

    @Column
    @NotEmpty
    private String alt;

    public Box() {
    }

    public Box(long id, @NotEmpty String boxName, @NotEmpty float price, @NotEmpty String boxDescription, @NotEmpty String imagePath, @NotEmpty String alt) {
        this.id = id;
        this.boxName = boxName;
        this.price = price;
        this.boxDescription = boxDescription;
        this.imagePath = imagePath;
        this.alt = alt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBoxDescription() {
        return boxDescription;
    }

    public void setBoxDescription(String boxDescription) {
        this.boxDescription = boxDescription;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return id == box.id && Float.compare(box.price, price) == 0 && Objects.equals(boxName, box.boxName) && Objects.equals(boxDescription, box.boxDescription) && Objects.equals(imagePath, box.imagePath) && Objects.equals(alt, box.alt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, boxName, price, boxDescription, imagePath, alt);
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", boxName='" + boxName + '\'' +
                ", price=" + price +
                ", boxDescription='" + boxDescription + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", alt='" + alt + '\'' +
                '}';
    }
}
