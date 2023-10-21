package it.discovery.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.discovery.monolith.domain.BaseEntity;
import it.discovery.monolith.domain.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order extends BaseEntity {
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    @ManyToOne
    private Customer customer;

    private boolean payed;

    private boolean completed;

    private boolean cancelled;

    @JsonIgnore
    public double getAmount() {
        return items.stream().mapToDouble(item -> item.getBook().getPrice() * item.getNumber()).sum();
    }

    public void addItem(OrderItem item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

}
