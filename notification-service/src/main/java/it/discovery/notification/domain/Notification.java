package it.discovery.notification.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "notifications")
public class Notification extends BaseEntity {
    private String recipient;

    private String email;

    private String title;

    private String text;
}
