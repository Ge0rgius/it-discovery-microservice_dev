package it.discovery.notification.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class CustomerSetting extends BaseEntity {

    private boolean notifyByEmail;

    private boolean notifyByPhone;

}
