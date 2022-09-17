package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "Война и мир", 100, "Толстой");
    Book book2 = new Book(2, "Война миров", 120, "Уэллс");
    Book book3 = new Book(3, "Гарри Поттер", 130, "Роулинг");
    Smartphone smartphone1 = new Smartphone(10, "Krutoy", 10000, "Apple");
    Smartphone smartphone2 = new Smartphone(11, "Prostoy", 5000, "NotApple");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void ShouldFindAll() {

        Product[] expected = { book1, book2, book3, smartphone1, smartphone2 };
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveById() {

        int id = 3;
        manager.removeById(id);

        Product[] expected = { book1, book2, smartphone1, smartphone2 };
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchByName2() {

        Product[] expected = { book1, book2 };
        Product[] actual = manager.searchBy("Война");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldSearchByName1() {

        Product[] expected = { smartphone1 };
        Product[] actual = manager.searchBy("Krutoy");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldSearchByName0() {

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Super");

        Assertions.assertArrayEquals(expected, actual);

    }

}
