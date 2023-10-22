package it.discovery.notification.persistence;

import it.discovery.notification.domain.CustomerSetting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CustomerSettingRepositoryTest {

    @Container
    @ServiceConnection
    static MongoDBContainer mongo = new MongoDBContainer(DockerImageName.parse("mongo:6")).withExposedPorts(27017);

    @Autowired
    CustomerSettingRepository customerSettingRepository;

    @Test
    void save_success() {
        CustomerSetting setting = new CustomerSetting(true, true);
        CustomerSetting setting1 = customerSettingRepository.save(setting);
        assertNotNull(setting1.id());
        assertNotNull(setting1.createdAt());
    }
}