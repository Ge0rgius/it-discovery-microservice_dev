package it.discovery.monolith;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.discovery.monolith.domain.Book;
import it.discovery.monolith.domain.Customer;
import it.discovery.monolith.domain.Manager;
import it.discovery.monolith.domain.PaymentProvider;
import it.discovery.monolith.repository.BookRepository;
import it.discovery.monolith.repository.CustomerRepository;
import it.discovery.monolith.repository.ManagerRepository;
import it.discovery.monolith.repository.PaymentProviderRepository;

@SpringBootApplication
public class MonolithApplication {
	public static void main(String[] args) {
		SpringApplication.run(MonolithApplication.class, args);
	}
	
    @Bean
    public ApplicationRunner applicationRunner(
            BookRepository bookRepository, CustomerRepository customerRepository,
			PaymentProviderRepository paymentProviderRepository,
            ManagerRepository managerRepository) {
        return args -> {
    		Book book = new Book();
    		book.setName("Thinking in Java");
    		book.setPages(1150);
    		book.setYear(2006);
    		bookRepository.save(book);
    		
    		PaymentProvider provider = new PaymentProvider();
    		provider.setName("Stripe");
    		paymentProviderRepository.save(provider);
    		
    		Customer customer = new Customer();
    		customer.setId(1);
    		customer.setName("Sam Newman");
    		customer.setEmail("sam.newman@gmail.com");
    		customer.setProvider(provider);
    		customerRepository.save(customer);
    		
    		Manager manager = new Manager();
    		manager.setName("Peter");
    		manager.setPhone("123");
    		managerRepository.save(manager);    		
        };
    }

}