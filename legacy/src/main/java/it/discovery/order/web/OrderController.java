package it.discovery.order.web;

import it.discovery.monolith.domain.Order;
import it.discovery.monolith.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("{bookId}/{number}/{customerId}")
    public Order createOrder(@PathVariable int bookId, @PathVariable int number, @PathVariable int customerId) {
        return orderService.createOrder(bookId, number, customerId);
    }

    @PutMapping("{orderId}")
    public void addBook(@PathVariable int orderId, int bookId, int number) {
        orderService.addBook(orderId, bookId, number);
    }

    @PostMapping("{orderId}")
    public void completeOrder(@PathVariable int orderId) {
        orderService.complete(orderId);
    }

    @DeleteMapping("{orderId}")
    public void cancel(@PathVariable int orderId) {
        orderService.cancel(orderId);
    }

    @GetMapping
    public List<Order> findOrders() {
        return orderService.findOrders();
    }

    @GetMapping("{orderId}")
    public Order findOrderById(@PathVariable int orderId) {
        return orderService.findOrderById(orderId);
    }

}
