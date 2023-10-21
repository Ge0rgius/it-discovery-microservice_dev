package it.discovery.notification.domain;

import it.discovery.monolith.domain.BaseEntity;
import jakarta.persistence.*;
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
