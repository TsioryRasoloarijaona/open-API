package org.example.author;

import org.example.DBconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainAuthor {
    public static void main(String[] args) throws SQLException {
        Connection co = DBconnection.getConnection();
        AuthorCrud crud = new AuthorCrud(co);
       /* Author etoile = new Author("etoie" ,"M");
        Author rabezavana = new Author("rabezavana","F");
        Author gogs = new Author("gogs" , "M");*/

        /*System.out.println(crud.saveAuthor(etoile));*/

       /* List<Author> authors = new ArrayList<>();
        authors.add(rabezavana);
        authors.add(gogs);
        System.out.println(crud.saveAllAuthor(authors));*/

        System.out.println(crud.getAllAuthors());

       /* System.out.println(crud.deleteAuthor(etoile));*/
    }
}
