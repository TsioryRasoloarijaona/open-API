package org.example.author;

public class Author {
    private int idAuthor;
    private String authorName;
    private String sex;

    public Author(int idAuthor, String authorName, String sex) {
        this.idAuthor = idAuthor;
        this.authorName = authorName;
        this.sex = sex;
    }

    public Author(String authorName, String sex) {
        this.authorName = authorName;
        this.sex = sex;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getSex() {
        return sex;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", authorName='" + authorName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
