package it.discovery.monolith.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.discovery.monolith.domain.Book;
import it.discovery.monolith.domain.Customer;
import it.discovery.monolith.domain.Manager;
import it.discovery.monolith.domain.Order;
import it.discovery.monolith.repository.BookRepository;
import it.discovery.monolith.repository.CustomerRepository;
import it.discovery.monolith.repository.ManagerRepository;
import it.discovery.monolith.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ShopController {
	
	private String libraryName = "IT-Discovery Shop";
	
	private final BookRepository bookRepository;
	
	private final CustomerRepository customerRepository;
	
	private final ManagerRepository managerRepository;
	
	private final OrderService orderService;

	@GetMapping("library")
	public String getLibraryName() {
		return libraryName;
	}

	@GetMapping("books")
	public List<Book> getBooks() {
		return bookRepository.findAll();				
	}

	@GetMapping("books/{id}")
	public Book getBook(@PathVariable int id) {
		return bookRepository.findById(id).orElseThrow();				
	}

	@PostMapping("books")
	public Book saveBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@PutMapping("books/{id}")
	public void updateBook(@RequestBody Book book) {
		bookRepository.save(book);				
	}

	@PostMapping("orders/{bookId}/{number}/{customerId}")
	public Order createOrder(@PathVariable int bookId, @PathVariable int number, @PathVariable int customerId) {
		return orderService.createOrder(bookId, number, customerId);		
	}
	
	@PostMapping("customers")
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@GetMapping("customers")
	public List<Customer> findCustomers() {
		return customerRepository.findAll();				
	}

	@PutMapping("orders/{orderId}")
	public void addBook(@PathVariable int orderId, int bookId, int number) {
		orderService.addBook(orderId, bookId, number);
	}
	
	@PostMapping("orders/{orderId}")
	public void completeOrder(@PathVariable int orderId) {
		orderService.complete(orderId);
	}
	
	@DeleteMapping("orders/{orderId}")
	public void cancel(@PathVariable int orderId) {
		orderService.cancel(orderId);
	}
	
	@GetMapping("orders")
	public List<Order> findOrders() {
		return orderService.findOrders();
	}
	
	@GetMapping("orders/{orderId}")
	public Order findOrderById(@PathVariable int orderId) {
		return orderService.findOrderById(orderId);
	}
	
	@GetMapping("managers")
	public List<Manager> findManagers() {
		return managerRepository.findAll();
	}

	@PostMapping("managers")
	public void saveManager(@RequestBody Manager manager) {
		managerRepository.save(manager);
	}

}
