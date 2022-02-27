package com.vegetables.website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    enum OrderStatus {
        NOT_STARTED,
        REFUSED,
        ACCEPTED,
        PACKING,
        READY,
        DELIVERED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotEmpty
    private long webUserId;
    @Column
    @NotEmpty
    private long addressId;
    @Column
    @NotEmpty
    private float price;
    @Column
    @NotEmpty
    private OrderStatus orderStatus;
    @Column
    @NotEmpty
    private Date orderDate;
    @Column
    private Date deliveryDate;

    public Order() {
    }

    public Order(long id, @NotEmpty long webUserId, @NotEmpty long addressId, @NotEmpty float price, @NotEmpty Date orderDate, @NotEmpty Date deliveryDate) {
        this.id = id;
        this.webUserId = webUserId;
        this.addressId = addressId;
        this.price = price;
        this.orderStatus = OrderStatus.NOT_STARTED;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    public long getId() {
        return id;
    }

    public long getWebUserId() {
        return webUserId;
    }

    public long getAddressId() {
        return addressId;
    }

    public float getPrice() {
        return price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setWebUserId(long webUserId) {
        this.webUserId = webUserId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && webUserId == order.webUserId && addressId == order.addressId && Float.compare(order.price, price) == 0 && orderStatus == order.orderStatus && Objects.equals(orderDate, order.orderDate) && Objects.equals(deliveryDate, order.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, webUserId, addressId, price, orderStatus, orderDate, deliveryDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", webUserId=" + webUserId +
                ", addressId=" + addressId +
                ", price=" + price +
                ", orderStatus=" + orderStatus +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
