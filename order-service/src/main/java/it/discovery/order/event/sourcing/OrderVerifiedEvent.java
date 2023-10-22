package it.discovery.order.event.sourcing;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVerifiedEvent extends BaseEventSourcingEvent implements EventSourcingEvent {

    public OrderVerifiedEvent(String entityId) {
        super(entityId);
    }
}
