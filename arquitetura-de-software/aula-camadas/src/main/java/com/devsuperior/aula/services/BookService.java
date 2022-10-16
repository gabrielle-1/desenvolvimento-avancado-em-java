package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.BookDTO;
import com.devsuperior.aula.dto.BookInsertDTO;
import com.devsuperior.aula.entities.Book;
import com.devsuperior.aula.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> listAll(){
        List<Book> books = this.bookRepository.findAll();
        return books.stream().map((x) -> new BookDTO(x)).collect(Collectors.toList());
    }

    public BookDTO create(BookInsertDTO book){

        Book obj = new Book();
        obj.setAuthor(book.getAuthor());
        obj.setTitle(book.getTitle());
        obj.setPrice(book.getPrice());

        obj = bookRepository.save(obj);
        return new BookDTO(obj);
    }

}
