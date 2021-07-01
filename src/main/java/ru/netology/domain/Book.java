package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String author;
    private int pages;
    private int publishedYear;

    public Book(String author, int pages, int publishedYear) {
        this.author = author;
        this.pages = pages;
        this.publishedYear = publishedYear;
    }

    public Book(int id, String name, int price, String author, int pages, int publishedYear) {
        super(id, name, price);
        this.author = author;
        this.pages = pages;
        this.publishedYear = publishedYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages && publishedYear == book.publishedYear && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, pages, publishedYear);
    }
}
