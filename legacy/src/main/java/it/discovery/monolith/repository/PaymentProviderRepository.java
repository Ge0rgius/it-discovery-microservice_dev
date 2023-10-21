package it.discovery.monolith.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.discovery.monolith.domain.PaymentProvider;

public interface PaymentProviderRepository extends JpaRepository<PaymentProvider, Integer> {

}
