package ru.netology.manager;

import ru.netology.product.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {

    protected ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.add(product);
    }

    public Product[] findAll() {
        return repo.findAll();
    }

    public Product[] removeById(int id) {
        repo.removeById(id);
        return new Product[0];
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length +1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
