package it.discovery.order.domain;

import it.discovery.order.event.sourcing.OrderCreatedEvent;
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

    //Used for event sourcing
    private int customerId;

    private boolean payed;

    private boolean completed;

    private boolean cancelled;

    private boolean verified;

    public double getAmount() {
        return items.stream().mapToDouble(item -> item.getPrice() * item.getNumber()).sum();
    }

    public void addItem(OrderItem item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    public void apply(OrderCreatedEvent event) {
        //setId(event.getEntityId());
        addItem(new OrderItem(event.getBookId(), event.getNumber(), event.getPrice()));
        setCustomerId(event.getCustomerId());
    }

}
