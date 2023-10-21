package it.discovery.monolith.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Customer extends BaseEntity {
	private String name;

	private String address;

	private String phone;

	private String email;

	private String cardNumber;

	private double balance;

	@ManyToOne
	@JoinColumn(name = "provider_id")
	private PaymentProvider provider;

	@OneToMany
	private List<Order> orders;

	@OneToMany
	private List<Payment> payments;
	
	private boolean notifyByEmail;
	
	private boolean notifyByPhone;

}
