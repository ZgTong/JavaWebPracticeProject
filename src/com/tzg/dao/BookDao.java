package com.tzg.dao;

import com.tzg.pojo.Book;

import java.util.List;

public interface BookDao {
    public List<Book> queryBooks();
    public Book queryBookById(Integer id);
    public int updateBook(Book book);
    public int deleteBookById(Integer id);
    public int addBook(Book book);
}
