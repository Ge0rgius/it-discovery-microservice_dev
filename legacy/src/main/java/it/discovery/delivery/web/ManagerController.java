package it.discovery.delivery.web;

import it.discovery.monolith.domain.Manager;
import it.discovery.monolith.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("managers")
public class ManagerController {

    private final ManagerRepository managerRepository;

    @GetMapping
    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody Manager manager) {
        managerRepository.save(manager);
    }

}
