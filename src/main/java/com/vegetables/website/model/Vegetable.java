package com.vegetables.website.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
    private String iconPath;

    @Column
    @NotEmpty
    private String alt;

    public Vegetable() {
    }

    public Vegetable(long id, @NotEmpty String vegetableName, @NotEmpty String iconPath, @NotEmpty String alt) {
        this.id = id;
        this.vegetableName = vegetableName;
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
        return id == vegetable.id && Objects.equals(vegetableName, vegetable.vegetableName)
                && Objects.equals(iconPath, vegetable.iconPath) && Objects.equals(alt, vegetable.alt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vegetableName, iconPath, alt);
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "id=" + id +
                ", vegetableName='" + vegetableName + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", alt='" + alt + '\'' +
                '}';
    }
}

