package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;

public interface BookService {
    Book findById(Integer id);
    List<Book>findAll();
    Book pushBook(Book book);

    Book editBook(Book book, Integer id);

    Boolean deleteBook(Integer id);
}
