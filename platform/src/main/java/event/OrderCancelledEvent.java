package event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderCancelledEvent extends BaseOrderEvent {

    public OrderCancelledEvent(int orderId) {
        super(orderId);
    }
}
