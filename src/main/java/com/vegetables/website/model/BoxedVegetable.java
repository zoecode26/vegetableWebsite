package com.vegetables.website.model;

import javax.persistence.*;
import java.util.Objects;

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

    @Column(name = "quantity")
    private int quantity;

    public BoxedVegetable() {
    }

    public BoxedVegetable(Long id, Long vegetableId, Long boxId, int quantity) {
        this.id = id;
        this.vegetableId = vegetableId;
        this.boxId = boxId;
        this.quantity = quantity;
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

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxedVegetable that = (BoxedVegetable) o;
        return quantity == that.quantity && Objects.equals(id, that.id) && Objects.equals(vegetableId, that.vegetableId) && Objects.equals(boxId, that.boxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vegetableId, boxId, quantity);
    }

    @Override
    public String toString() {
        return "BoxedVegetables{" +
                "id=" + id +
                ", vegetableId=" + vegetableId +
                ", boxId=" + boxId +
                ", quantity=" + quantity +
                '}';
    }
}
