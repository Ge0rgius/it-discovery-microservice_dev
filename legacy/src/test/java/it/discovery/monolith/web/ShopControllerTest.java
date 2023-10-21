package it.discovery.monolith.web;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.discovery.monolith.domain.Book;
import it.discovery.monolith.domain.Customer;
import it.discovery.monolith.domain.Order;

@SpringBootTest
@AutoConfigureMockMvc
public class ShopControllerTest {
	@Autowired
	MockMvc mockMvc;

	static final ObjectMapper MAPPER = new ObjectMapper();
	
	@BeforeEach
	void setup() {
		MAPPER.findAndRegisterModules();
	}

	@Test
	void createAndCompleteOrder_success() throws Exception {
		// Create book
		Book book = new Book();
		book.setName("Microservice development");

		ResultActions actions = mockMvc.perform(
				post("/books").content(MAPPER.writeValueAsBytes(book)).contentType(MediaType.APPLICATION_JSON));
		actions.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
		MvcResult bookResult = actions.andReturn();
		String body = bookResult.getResponse().getContentAsString();
		book = MAPPER.readValue(body, Book.class);

		// Create customer
		Customer customer = new Customer();
		customer.setEmail("customer@gmail.com");
		customer.setName("John Stones");

		actions = mockMvc.perform(
				post("/customers").content(MAPPER.writeValueAsBytes(customer)).contentType(MediaType.APPLICATION_JSON));
		actions.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
		MvcResult customerResult = actions.andReturn();
		String responseBody = customerResult.getResponse().getContentAsString();
		customer = MAPPER.readValue(responseBody, Customer.class);

		// Create order
		actions = mockMvc.perform(post("/orders/{bookId}/1/{customerId}", book.getId(), customer.getId()));
		actions.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

		MvcResult orderResult = actions.andReturn();
		String orderBody = orderResult.getResponse().getContentAsString();
		Order order = MAPPER.readValue(orderBody, Order.class);

		// Complete order
		actions = mockMvc.perform(post("/orders/{orderId}", order.getId()));
		actions.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

		// Verify order status
		actions = mockMvc.perform(get("/orders/{orderId}", order.getId()));
		actions.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.completed", equalTo(true)))
				.andExpect(jsonPath("$.payed", equalTo(true)))
				.andExpect(jsonPath("$.delivered", equalTo(true)))
				.andExpect(jsonPath("$.customer.id", equalTo(customer.getId())));

	}

}
