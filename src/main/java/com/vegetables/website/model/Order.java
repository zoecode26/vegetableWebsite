package com.vegetables.website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NotEmpty
    private long webUserId;
    @Column
    @NotEmpty
    private float price;
    @Column
    @NotEmpty
    private Date orderDate;

    public Order() {
    }

    public Order(long id, @NotEmpty long webUserId, @NotEmpty float price, @NotEmpty Date orderDate, @NotEmpty Date deliveryDate) {
        this.id = id;
        this.webUserId = webUserId;
        this.price = price;
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public long getWebUserId() {
        return webUserId;
    }

    public float getPrice() {
        return price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setWebUserId(long webUserId) {
        this.webUserId = webUserId;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && webUserId == order.webUserId && Float.compare(order.price, price) == 0 && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, webUserId, price, orderDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", webUserId=" + webUserId +
                ", price=" + price +
                ", orderDate=" + orderDate +
                '}';
    }
}