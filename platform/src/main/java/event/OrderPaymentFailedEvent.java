package event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderPaymentFailedEvent extends BaseOrderEvent {

    public OrderPaymentFailedEvent(int orderId) {
        super(orderId);
    }
}
