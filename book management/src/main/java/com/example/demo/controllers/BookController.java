package com.example.demo.controllers;


import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping("")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable("bookId") int bookId){
        return bookService.getBookById(bookId);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId,
                           @RequestBody Book updatedBook){
        return bookService.updateBook(bookId, updatedBook);
    }

    @DeleteMapping("/{bookId}")
    public Book deleteBook(@PathVariable("bookId") int bookId){
        return bookService.deleteBook(bookId);
    }
}
