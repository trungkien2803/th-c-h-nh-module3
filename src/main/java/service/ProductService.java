package service;

import dao.IProductDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

import java.util.List;

public class ProductService implements IProductService{
    IProductDAO productDAO = new ProductDAO();
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }
    public List<Category> findAllCategory(){
        return productDAO.findAllCategory();
    }

    @Override
    public List<Product> findByName(String id) {
        return productDAO.findByName(id);
    }

    @Override
    public boolean create(Product product) {
        return productDAO.create(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return productDAO.update(id,product);
    }

    @Override
    public boolean delete(int id) {
        return productDAO.delete(id);
    }
}
