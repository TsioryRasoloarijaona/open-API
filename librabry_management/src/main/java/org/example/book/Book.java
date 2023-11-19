package org.example.book;

import org.example.author.Author;

import java.util.Date;
import java.util.List;

public class Book {
    private int bookId;
    private String bookName;
    private int pageNumbers;
    private Date dateRealise;
    private Author author;
    private List<String> topics;

    public Book(int bookId, String bookName, int pageNumbers, Date dateRealise, Author author,List<String> topics) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;
        this.dateRealise = dateRealise;
        this.author = author;
        this.topics =  topics;
    }

    public Book(String bookName, int pageNumbers, Author author , List<String> topics) {
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;
        this.author = author;
        this.topics =  topics;

    }

    public Book(int bookId, String bookName, int pageNumbers) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;


    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public List<String>  getTopics() {
        return topics;
    }

    public Date getDateRealise() {
        return dateRealise;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public void setTopics(List<String>  topics) {
        this.topics = topics;
    }

    public void setDateRealise(Date dateRealise) {
        this.dateRealise = dateRealise;
    }
}
