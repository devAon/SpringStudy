package com.example.demo.services;

import com.example.demo.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private int autoIncrement = 1;

    public Book saveBook(Book book){
        book.setId(autoIncrement++);

        books.add(book);

        return book;
    }

    public List<Book> getAllBooks() {
        return this.books;
    }

    public Book getBookById(int bookId){
        for(Book book : books){
            if(book.getId() == bookId){
                return book;
            }
        }
        return null;
    }


    public Book updateBook(int bookId, Book updatedBook){
        for(Book book : books){
            if(book.getId() == bookId){
                book.setAuthor(book.getAuthor());
                book.setTitle(book.getTitle());
                book.setOut(book.isOut());

                return book;
            }
        }
        updatedBook.setId(autoIncrement++);
        books.add(updatedBook);
        return null;
    }

    public Book deleteBook(int bookId){
        for(Book book : books){
            if(book.getId() == bookId){
                books.remove(book);
                return book;
            }
        }
        return null;
    }
}
