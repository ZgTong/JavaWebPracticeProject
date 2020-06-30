package com.tzg.test;

import com.tzg.dao.BookDao;
import com.tzg.dao.impl.BookDaoImpl;
import com.tzg.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void queryBooks() {
        for (Book book:bookDao.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(25));
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"TZGDSG","tzg",new BigDecimal(20),1,0,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(23);
    }

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"TZGDSG","tzg",new BigDecimal(100),111111,0,null));
    }
}