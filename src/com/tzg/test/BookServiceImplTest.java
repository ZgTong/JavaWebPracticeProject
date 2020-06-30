package com.tzg.test;

import com.tzg.pojo.Book;
import com.tzg.service.BookService;
import com.tzg.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"tzgall","tzg",new BigDecimal(23),333,22,null));
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
        bookService.addBook(new Book(24,"tzgall","tzg",new BigDecimal(23),333,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(24));

    }

    @Test
    public void queryBooks() {
        System.out.println(bookService.queryBooks());
    }
}