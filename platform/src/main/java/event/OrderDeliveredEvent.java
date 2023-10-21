package event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDeliveredEvent extends BaseOrderEvent {

    public OrderDeliveredEvent(int orderId) {
        super(orderId);
    }
}
