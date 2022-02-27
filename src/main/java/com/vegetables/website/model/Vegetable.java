package com.vegetables.website.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vegetables")
public class Vegetable {

    enum PriceBracket {
        LOW,
        MEDIUM,
        HIGH
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotEmpty
    private String vegetableName;

    @Column
    @NotEmpty
    private String priceBracket;

    @Column
    @NotEmpty
    private String iconPath;

    @Column
    @NotEmpty
    private String alt;

    public Vegetable() {
    }

    public Vegetable(long id, @NotEmpty String vegetableName, @NotEmpty String priceBracket, @NotEmpty String iconPath, @NotEmpty String alt) {
        this.id = id;
        this.vegetableName = vegetableName;
        this.priceBracket = priceBracket;
        this.iconPath = iconPath;
        this.alt = alt;
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

    public String getPriceBracket() {
        return priceBracket;
    }

    public void setPriceBracket(String priceBracket) {
        this.priceBracket = priceBracket;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
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
        Vegetable vegetable = (Vegetable) o;
        return id == vegetable.id && Objects.equals(vegetableName, vegetable.vegetableName) && priceBracket == vegetable.priceBracket && Objects.equals(iconPath, vegetable.iconPath) && Objects.equals(alt, vegetable.alt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vegetableName, priceBracket, iconPath, alt);
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "id=" + id +
                ", vegetableName='" + vegetableName + '\'' +
                ", priceBracket=" + priceBracket +
                ", iconPath='" + iconPath + '\'' +
                ", alt='" + alt + '\'' +
                '}';
    }
}

