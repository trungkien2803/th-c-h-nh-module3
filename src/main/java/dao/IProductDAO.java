package dao;

import model.Category;
import model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> findAll();
    List<Category> findAllCategory();
    List<Product> findByName(String name);
    boolean create(Product product);
    boolean update(int id, Product product);
    boolean delete(int id);
}
