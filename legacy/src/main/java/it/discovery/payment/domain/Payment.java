package it.discovery.payment.domain;

import it.discovery.monolith.domain.BaseEntity;
import it.discovery.monolith.domain.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Payment extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "provider_id")
	private PaymentProvider provider;
	
	private boolean success;
	
	private String transactionId;
	
	private double amount;

}
