package it.discovery.notification.persistence;

import it.discovery.monolith.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
	
}
