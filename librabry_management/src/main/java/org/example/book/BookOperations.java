package org.example.book;

import java.util.List;

public interface BookOperations {
    List<Book> getAllBook();

    List<Book> saveAllBook(List<Book> books);
    Book saveBook(Book toSave);
    Book deleteBook(Book toDelete);
}
