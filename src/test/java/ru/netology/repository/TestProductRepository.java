package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;


class TestProductRepository {

    @Test
    public void shouldRemoveExistId() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book first = new Book(1, "book1", 1000, "Nekrasov", 200, 2010);
        Book second = new Book(2, "book2", 1500, "Nekrasov", 250, 2018);
        Book third = new Book(3, "book3", 2100, "Nekrasov", 360, 2020);

        repository.save(first);
        repository.save(second);
        repository.save(third);

        repository.removeById(3);

        Product[] expected = {first, second};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNotExistId() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book first = new Book(1, "book1", 1000, "Nekrasov", 200, 2010);
        Book second = new Book(2, "book2", 1500, "Nekrasov", 250, 2018);
        Book third = new Book(3, "book3", 2100, "Nekrasov", 360, 2020);

        repository.save(first);
        repository.save(second);
        repository.save(third);

        assertThrows(NotFoundException.class, () -> {

            repository.removeById(10);
        });
    }


}