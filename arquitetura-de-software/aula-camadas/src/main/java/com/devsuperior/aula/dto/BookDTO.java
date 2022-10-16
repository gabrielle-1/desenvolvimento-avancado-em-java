package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Book;

public class BookDTO {

    private Long id;
    private String title;
    private String author;

    public BookDTO(Long id, String title, String author, double price){
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public BookDTO(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
