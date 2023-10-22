package it.discovery.order.client.api;

import it.discovery.order.client.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class OrderClient implements OrderFacade {

    private final String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<OrderDTO> findAll() {
        //TODO
        return null;
    }

    @Override
    public Optional<OrderDTO> findOne(int orderId) {
        try {
            return Optional.ofNullable(restTemplate.
                    getForObject(STR. "\{ baseUrl }/orders/\{ orderId }" , OrderDTO.class));
        } catch (Exception ex) {
            //log.error();
            return Optional.empty();
        }
    }
}
