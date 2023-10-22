package it.discovery.notification.service;

import it.discovery.notification.domain.Notification;
import it.discovery.notification.persistence.NotificationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
class NotificationServiceTest {

    @Container
    @ServiceConnection
    static MongoDBContainer mongo = new MongoDBContainer(DockerImageName.parse("mongo:6")).withExposedPorts(27017);

    @Autowired
    NotificationService notificationService;

    @Autowired
    NotificationRepository notificationRepository;

    @Test
    void sendNotification_notificationSaved() {
        Notification notification = new Notification();
        notification.setEmail("test");
        notification.setText("Payment success");
        notification.setTitle("Payment notification");
        notification.setRecipient("Test user");
        notificationService.sendNotification(notification);

        List<Notification> notifications = notificationRepository.findAll();
        assertEquals(1, notifications.size());
        assertEquals(notification.getEmail(), notifications.get(0).getEmail());
    }
}