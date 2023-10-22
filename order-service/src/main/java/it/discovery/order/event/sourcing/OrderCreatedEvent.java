package it.discovery.order.event.sourcing;

import lombok.Getter;

@Getter
public class OrderCreatedEvent extends BaseEventSourcingEvent implements EventSourcingEvent {

    private int bookId;

    private int customerId;

    private int number;

    private double price;

    public OrderCreatedEvent(String entityId) {
        super(entityId);
    }
}
