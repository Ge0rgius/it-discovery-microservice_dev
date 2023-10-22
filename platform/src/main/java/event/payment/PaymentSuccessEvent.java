package event.payment;

import event.BaseEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentSuccessEvent extends BaseEvent {

    public PaymentSuccessEvent(int paymentId) {
        super(paymentId);
    }
}
