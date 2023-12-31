package it.discovery.monolith.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.discovery.monolith.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
