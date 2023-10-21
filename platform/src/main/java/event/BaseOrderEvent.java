package event;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public abstract class BaseOrderEvent implements IntegrationEvent {

    private String id;

    private int entityId;

    private LocalDateTime created;

    public BaseOrderEvent(int orderId) {
        entityId = orderId;
        id = UUID.randomUUID().toString();
        created = LocalDateTime.now();
    }
}
