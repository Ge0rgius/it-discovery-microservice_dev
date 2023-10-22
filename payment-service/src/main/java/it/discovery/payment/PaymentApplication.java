package it.discovery.payment;

import it.discovery.payment.domain.PaymentProvider;
import it.discovery.payment.persistence.PaymentProviderRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(
            PaymentProviderRepository paymentProviderRepository) {
        return args -> {
            PaymentProvider provider = new PaymentProvider();
            provider.setName("Stripe");
            paymentProviderRepository.save(provider);

//            Customer customer = new Customer();
//            customer.setId(1);
//            customer.setName("Sam Newman");
//            customer.setEmail("sam.newman@gmail.com");
//            customer.setProvider(provider);
//            customerRepository.save(customer);
        };
    }
}
