package it.discovery.notification.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "settings")
public record CustomerSetting(@Id String id, @CreatedDate LocalDateTime createdAt, boolean notifyByEmail,
                              boolean notifyByPhone) {
    public CustomerSetting(boolean notifyByEmail,
                           boolean notifyByPhone) {
        this(null, null, notifyByEmail, notifyByPhone);
    }
}
