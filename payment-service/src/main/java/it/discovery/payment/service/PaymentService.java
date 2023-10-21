package it.discovery.payment.service;

import it.discovery.monolith.domain.Order;
import it.discovery.monolith.service.NotificationService;
import it.discovery.payment.domain.Payment;
import it.discovery.payment.persistence.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
	private final OrderRepository orderRepository;
	
	private final PaymentGateway paymentGateway;
	
	private final NotificationService notificationService;
	
	private final PaymentRepository paymentRepository;
	
	public void pay(Order order) {
		Payment payment = paymentGateway.charge(order);
		
		order.setPayed(true);
		orderRepository.save(order);
		
		paymentRepository.save(payment);

//		Notification notification = new Notification();
//		notification.setEmail(order.getCustomer().getEmail());
//		notification.setRecipient(order.getCustomer().getName());
//		notification.setTitle("Order " + order.getId() + " was payed");
//		notification.setText("Hi/n. Your order was payed successfully");
//
//		notificationService.sendNotification(notification);
//		System.out.println("Charging completed");
	}

}
