package ru.netology.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    protected Customers customer;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "amount")
    private double amount;

    public Customers getCustomer() {
        return customer;
    }

    public String getProductName() {
        return productName;
    }

    public double getAmount() {
        return amount;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders order = (Orders) o;

        if (this.getId() != order.getId()) return false;
        if (!this.getCustomer().equals(order.getCustomer())) return false;
        if (!this.getProductName().equals(order.getProductName())) return false;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, productName, amount, customer);
    }*/

    /*@Override
    public String toString() {
        return "Orders{" +
                "date='" + date + '\'' +
                ", customer='" + customer + '\'' +
                ", productName=" + productName +
                ", amount=" + amount +
                '}';
    }*/
}