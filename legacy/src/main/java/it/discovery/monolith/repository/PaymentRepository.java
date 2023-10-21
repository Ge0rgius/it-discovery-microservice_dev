package it.discovery.monolith.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.discovery.monolith.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
