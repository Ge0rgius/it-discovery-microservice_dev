package event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderPayedEvent extends BaseOrderEvent {

    public OrderPayedEvent(int orderId) {
        super(orderId);
    }
}
