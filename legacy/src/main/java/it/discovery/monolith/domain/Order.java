package it.discovery.monolith.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

	private boolean delivered;

	private boolean cancelled;

	private LocalDateTime deliveryDate;

	private double deliveryPrice;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Manager deliveryManager;

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
