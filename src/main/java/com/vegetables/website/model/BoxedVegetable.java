package com.vegetables.website.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "boxed_vegetables")
public class BoxedVegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vegetable_id")
    private Long vegetableId;

    @Column(name = "box_id")
    private Long boxId;

    public BoxedVegetable() {
    }

    public BoxedVegetable(Long id, Long vegetableId, Long boxId) {
        this.id = id;
        this.vegetableId = vegetableId;
        this.boxId = boxId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(Long vegetableId) {
        this.vegetableId = vegetableId;
    }

    public Long getBoxId() {
        return boxId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxedVegetable that = (BoxedVegetable) o;
        return Objects.equals(id, that.id) && Objects.equals(vegetableId, that.vegetableId)
                && Objects.equals(boxId, that.boxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vegetableId, boxId);
    }

    @Override
    public String toString() {
        return "BoxedVegetables{" +
                "id=" + id +
                ", vegetableId=" + vegetableId +
                ", boxId=" + boxId +
                '}';
    }
}
