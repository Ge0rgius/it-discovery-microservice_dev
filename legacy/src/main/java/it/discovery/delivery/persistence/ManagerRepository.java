package it.discovery.delivery.persistence;

import it.discovery.monolith.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{

}
