package it.discovery.delivery.domain;

import it.discovery.monolith.domain.BaseEntity;
import it.discovery.monolith.domain.Order;
import it.discovery.monolith.domain.Payment;
import it.discovery.monolith.domain.PaymentProvider;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Customer extends BaseEntity {
	private String name;

	private String address;

	private String phone;

	private String email;

}
