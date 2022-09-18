package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;

public class RepositoryTest {

    ProductRepository repo = new ProductRepository();

    Book book1 = new Book(1, "Война и мир", 100, "Толстой");
    Book book2 = new Book(2, "Война миров", 120, "Уэллс");
    Book book3 = new Book(3, "Гарри Поттер", 130, "Роулинг");

    @Test
    public void ShouldRemoveById() {

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        int id = 3;
        repo.removeById(id);

        Product[] expected = { book1, book2 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveByIdNotFind() {

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        int id = 4;

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        } );
    }

    @Test
    public void ShouldFindById() {

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        int id = 2;
        repo.findById(id);

        Product[] expected = { book2 };
        Product[] actual = repo.findById(id);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldFindByIdNot() {

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        int id = 4;
        repo.findById(id);

        Product[] expected = null;
        Product[] actual = repo.findById(id);

        Assertions.assertArrayEquals(expected, actual);

    }

}
