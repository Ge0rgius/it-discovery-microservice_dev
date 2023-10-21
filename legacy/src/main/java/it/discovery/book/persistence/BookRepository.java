package it.discovery.book.persistence;

import it.discovery.monolith.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
}
