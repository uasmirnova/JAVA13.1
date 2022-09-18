package ru.netology.repository;

import ru.netology.product.Product;

public class ProductRepository {

    protected Product[] products = new Product[0];

    public Product[] findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return new Product[]{product};
            }
        }
        return null;
    }

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        Product[] findId = findById(id);
        if (findId != null) {
            Product[] tmp = new Product[products.length - 1];
            int copyToIndex = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[copyToIndex] = product;
                    copyToIndex++;
                }
            }
            products = tmp;
        } else {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
    }
}
