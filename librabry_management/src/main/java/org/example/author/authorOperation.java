package org.example.author;

import java.util.List;

public interface authorOperation {

     List<Author> getAllAuthors();

     List<Author> saveAllAuthor(List<Author> authors);
    Author saveAuthor(Author toSave);
    Author deleteAuthor(Author toDelete);


}
