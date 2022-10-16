package com.devsuperior.aula.repositories;

import com.devsuperior.aula.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
