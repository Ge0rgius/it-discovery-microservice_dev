package it.discovery.order.domain;

import it.discovery.monolith.domain.BaseEntity;
import it.discovery.monolith.domain.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class OrderItem extends BaseEntity {
	@ManyToOne
	private Book book;

	private int number;
}
