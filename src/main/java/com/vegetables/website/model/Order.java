package com.vegetables.website.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

    @Column
    @NotEmpty
    private String imgPath;

    public Order() { }

    public Order(long id, @NotEmpty long webUserId, @NotEmpty float price, @NotEmpty Date orderDate,
                 @NotEmpty Date deliveryDate, @NotEmpty String imgPath) {
        this.id = id;
        this.webUserId = webUserId;
        this.price = price;
        this.orderDate = orderDate;
        this.imgPath = imgPath;
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

    public String getImgPath() { return imgPath; }

    public void setImgPath(String imgPath) { this.imgPath = imgPath; }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", webUserId=" + webUserId +
                ", price=" + price +
                ", orderDate=" + orderDate +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && webUserId == order.webUserId && Float.compare(order.price, price) == 0
                && Objects.equals(orderDate, order.orderDate) && Objects.equals(imgPath, order.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, webUserId, price, orderDate, imgPath);
    }
}
