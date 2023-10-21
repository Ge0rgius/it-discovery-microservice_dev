package it.discovery.monolith.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import it.discovery.monolith.domain.Book;
import it.discovery.monolith.domain.Manager;
import it.discovery.monolith.domain.Notification;
import it.discovery.monolith.domain.Order;
import it.discovery.monolith.domain.OrderItem;
import it.discovery.monolith.repository.BookRepository;
import it.discovery.monolith.repository.ManagerRepository;
import it.discovery.monolith.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeliveryService {
	private final OrderRepository orderRepository;
	
	private final BookRepository bookRepository;

	private final ManagerRepository managerRepository;

	private final NotificationService notificationService;

	public void deliver(Order order) {
		//TODO find all non-busy managers
		List<Manager> managers = managerRepository.findAll();
		Manager deliveryManager = managers.get(0);

		order.setDelivered(true);
		order.setDeliveryDate(LocalDateTime.now());
		order.setDeliveryManager(deliveryManager);

		orderRepository.save(order);
		
		for(OrderItem item : order.getItems()) {
			Book book = item.getBook();
			book.setAmount(book.getAmount() - item.getNumber());
			bookRepository.save(book);
		}

		Notification notification = new Notification();
		notification.setEmail(order.getCustomer().getEmail());
		notification.setRecipient(order.getCustomer().getName());
		notification.setTitle("Order " + order.getId() + " is delivered");
		notification.setText("Hi/n. Your order has been delivered");

		notificationService.sendNotification(notification);

		System.out.println("Order delivered!");
	}

}
