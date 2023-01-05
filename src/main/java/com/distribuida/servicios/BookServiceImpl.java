package com.distribuida.servicios;

import com.distribuida.config.DbConfig;
import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService {
    private List<Book> books = new ArrayList<>();

    private Jdbi jdbi = DbConfig.con2();
    private Handle handle = jdbi.open();

    public Book findById(Integer id){
      return handle.createQuery("SELECT * FROM books WHERE id = :id")
              .bind("id", id)
              .mapToBean(Book.class)
              .findOnly();
    }
    public List<Book> findAll(){
        return handle.createQuery("SELECT * FROM \"books\"")
                .mapToBean(Book.class)
                .list();
    }
    public Book pushBook(Book book){
        try {
            handle.createUpdate("INSERT INTO books (isbn, title, author, price) VALUES (:isbn, :title, :author, :price)")
                    .bind("isbn", book.getIsbn())
                    .bind("title", book.getTitle())
                    .bind("author", book.getAuthor())
                    .bind("price", book.getPrice())
                    .execute();
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Book editBook(Book book, Integer id){
        try {
            handle.createUpdate("UPDATE books SET isbn = :isbn, title = :title, author = :author, price = :price WHERE id = :id")
                    .bind("isbn", book.getIsbn())
                    .bind("title", book.getTitle())
                    .bind("author", book.getAuthor())
                    .bind("price", book.getPrice())
                    .bind("id", id)
                    .execute();
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Boolean deleteBook(Integer id){
        try {
            handle.createUpdate("DELETE FROM books WHERE id = :id")
                    .bind("id", id)
                    .execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
