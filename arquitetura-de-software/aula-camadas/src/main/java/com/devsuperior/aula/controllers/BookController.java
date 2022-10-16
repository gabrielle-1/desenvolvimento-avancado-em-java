package com.devsuperior.aula.controllers;

import com.devsuperior.aula.dto.BookDTO;
import com.devsuperior.aula.dto.BookInsertDTO;
import com.devsuperior.aula.services.BookService;
import com.devsuperior.aula.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

        @Autowired
        private BookService bookService;

        @GetMapping
        public ResponseEntity<List<BookDTO>> findAll() {
            List<BookDTO> list = bookService.listAll();
            return ResponseEntity.ok(list);
        }

        @PostMapping
        public ResponseEntity<BookDTO> insert(@RequestBody BookInsertDTO dto) {
            try {
                BookDTO obj = bookService.create(dto);

                // Headers Location of request
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(obj.getId()).toUri();
                return ResponseEntity.created(uri).body(obj);
            } catch (ServiceException e) {
                return ResponseEntity.unprocessableEntity().build();
            }
        }
}

