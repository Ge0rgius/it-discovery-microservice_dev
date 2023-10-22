package it.discovery.notification.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseEntity {
    @Id
    private String id;

    @CreatedDate
    private LocalDateTime createdAt;
}
