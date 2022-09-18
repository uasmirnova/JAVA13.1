package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;

public class RepositoryTest {

    ProductRepository repo = new ProductRepository();

    Book book1 = new Book(1, "Война и мир", 100, "Толстой");
    Book book2 = new Book(2, "Война миров", 120, "Уэллс");
    Book book3 = new Book(3, "Гарри Поттер", 130, "Роулинг");
    Book book4 = new Book(4, "Незнайка", 500, "Носов");
    Book book5 = new Book(2, "Буратино", 439, "Толстой");

    @BeforeEach
    public void setUp() {
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
    }

    @Test
    public void ShouldRemoveById() {

        int id = 3;
        repo.removeById(id);

        Product[] expected = { book1, book2 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveByIdNotFind() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        } );
    }

    @Test
    public void ShouldAddNewProduct() {

        repo.add(book4);

        Product[] expected = { book1, book2, book3, book4 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldNotAddNewProduct() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(book5);
        } );
    }

    @Test
    public void ShouldFindById() {

        int id = 2;
        repo.findById(id);

        Product expected = book2;
        Product actual = repo.findById(id);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldFindByIdNot() {

        int id = 4;
        repo.findById(id);

        Product expected = null;
        Product actual = repo.findById(id);

        Assertions.assertEquals(expected, actual);

    }

}
