package it.discovery.notification.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "settings")
public class CustomerSetting extends BaseEntity {

    private boolean notifyByEmail;

    private boolean notifyByPhone;

}
