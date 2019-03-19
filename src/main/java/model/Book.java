package model;

import java.util.Objects;

public class Book extends Publication {

    public static final String TYPE = "Book";

    private String author;
    private int pagesNumber;
    private String isbn;


    public Book(String title, String author, int year, int pagesNumber, String publisher, String isbn) {

        super(year, title, publisher);
        this.author = author;
        this.pagesNumber = pagesNumber;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" + super.toString() +
                "author='" + author + '\'' +
                ", pagesNumber=" + pagesNumber +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pagesNumber == book.pagesNumber &&
                author.equals(book.author) &&
                isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, pagesNumber, isbn);
    }

    @Override
    public String toCsv() {
        return (TYPE+";")+
                getTitle()+";"+
                getPublisher()+";"+
                getYear()+";"+
                author+";"+
                pagesNumber+";"+
                isbn+ "";
    }
}
