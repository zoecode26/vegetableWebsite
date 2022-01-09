package com.vegetables.website.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vegetables")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotEmpty
    private String vegetableName;
    @Column
    @NotEmpty
    private Float price;

    public Vegetable() {
    }

    public Vegetable(long id, @NotEmpty String vegetableName, @NotEmpty Float price) {
        this.id = id;
        this.vegetableName = vegetableName;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vegetable vegetable = (Vegetable) o;
        return id == vegetable.id && Objects.equals(vegetableName, vegetable.vegetableName) && Objects.equals(price, vegetable.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vegetableName, price);
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "id=" + id +
                ", vegetableName='" + vegetableName + '\'' +
                ", price=" + price +
                '}';
    }
}
