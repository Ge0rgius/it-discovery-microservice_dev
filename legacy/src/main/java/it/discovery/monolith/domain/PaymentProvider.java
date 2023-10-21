package it.discovery.monolith.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class PaymentProvider extends BaseEntity {

	private String name;
	
	private double commission;
	
	@OneToMany(mappedBy = "provider")
	private List<Payment> payments;
	
	@OneToMany(mappedBy = "provider")
	private List<Customer> customers;
}
