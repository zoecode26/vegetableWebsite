package com.vegetables.website.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotEmpty
    private long orderId;

    @Column
    @NotEmpty
    private long boxId;

    @Column
    @NotEmpty
    private int quantity;

    public OrderItem() { }

    public OrderItem(long id, long orderId, long boxId, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.boxId = boxId;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getBoxId() {
        return boxId;
    }

    public void setBoxId(long boxId) {
        this.boxId = boxId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id == orderItem.id && orderId == orderItem.orderId
                && boxId == orderItem.boxId && quantity == orderItem.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, boxId, quantity);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", boxId=" + boxId +
                ", quantity=" + quantity +
                '}';
    }
}

