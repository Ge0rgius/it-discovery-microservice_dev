package it.discovery.monolith.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.discovery.monolith.domain.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{

}
