package it.discovery.notification.persistence;

import it.discovery.notification.domain.CustomerSetting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerSettingRepository extends MongoRepository<CustomerSetting, String> {
}
