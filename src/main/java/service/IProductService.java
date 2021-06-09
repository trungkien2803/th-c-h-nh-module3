package service;

import model.Category;
import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Category> findAllCategory();
    List<Product> findByName(String id);
    boolean create(Product product);
    boolean update(int id, Product product);
    boolean delete(int id);
}
