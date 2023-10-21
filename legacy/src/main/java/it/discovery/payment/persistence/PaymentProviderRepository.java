package it.discovery.payment.persistence;

import it.discovery.monolith.domain.PaymentProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentProviderRepository extends JpaRepository<PaymentProvider, Integer> {

}
