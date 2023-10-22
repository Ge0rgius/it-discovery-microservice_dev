package it.discovery.delivery.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order extends BaseEntity {

    private boolean delivered;

    private LocalDateTime deliveryDate;

    private double deliveryPrice;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager deliveryManager;

}
