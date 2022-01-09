package com.vegetables.website.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
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

    public Box() {
    }

    public Box(long id, @NotEmpty String boxName) {
        this.id = id;
        this.boxName = boxName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return id == box.id && Objects.equals(boxName, box.boxName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, boxName);
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", boxName='" + boxName + '\'' +
                '}';
    }
}
