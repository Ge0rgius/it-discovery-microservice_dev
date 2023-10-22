package it.discovery.order.domain;

import it.discovery.order.event.sourcing.EventSourcingEvent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "eventstore")
public class EventLog {

    @Id
    private String id;

    @Indexed
    private String entityId;

    private String type;

    @Indexed
    @CreatedDate
    private LocalDateTime created;

    private int userId;

    private EventSourcingEvent payload;

    public EventLog(String entityId, String type, EventSourcingEvent payload) {
        this.entityId = entityId;
        this.type = type;
        this.payload = payload;
    }
}
