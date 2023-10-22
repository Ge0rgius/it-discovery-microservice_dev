package it.discovery.order.persistence;

import it.discovery.order.domain.EventLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Set;

public interface EventLogRepository extends MongoRepository<EventLog, String> {

    List<EventLog> findByEntityIdOrderByCreatedAsc(String entityId);

    @Query(value = "{}", fields = "{'entityId: 1, '_id': 0}")
    Set<Entity> findEntityIds();

    public interface Entity {
        String entityId();
    }
}
