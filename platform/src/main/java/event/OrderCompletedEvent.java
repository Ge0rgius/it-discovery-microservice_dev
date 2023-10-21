package event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderCompletedEvent extends BaseOrderEvent {

    public OrderCompletedEvent(int orderId) {
        super(orderId);
    }
}
