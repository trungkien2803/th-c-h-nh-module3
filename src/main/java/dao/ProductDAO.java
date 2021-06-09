package dao;

import model.Category;
import model.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{
    private final String FIND_ALL_PRODUCT = "call finAllProduct";
    private final String FIND_ALL_CATEGORY = "call finAllCategory";
    private final String CREATE_PRODUCT = "call createProduct(?,?,?,?,?,?)";
    private final String DELETE_PRODUCT = "call deleteProduct(?)";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Connection connection = SQLConnection.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(FIND_ALL_PRODUCT);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double amount = resultSet.getDouble("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String categoryName = resultSet.getString("categoryName");
                products.add(new Product(id,name,price,amount,color,description,categoryName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    @Override
    public List<Category> findAllCategory() {
        List<Category> categories = new ArrayList<>();
        Connection connection = SQLConnection.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(FIND_ALL_CATEGORY);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("categoryName");
                categories.add(new Category(id,name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean create(Product product) {
        Connection connection = SQLConnection.getConnection();
        int rowInsert = 0;
        try {
            CallableStatement callableStatement = connection.prepareCall(CREATE_PRODUCT);
            callableStatement.setString(1,product.getName());
            callableStatement.setDouble(2,product.getPrice());
            callableStatement.setDouble(3,product.getAmount());
            callableStatement.setString(4,product.getColor());
            callableStatement.setString(5,product.getDescription());
            callableStatement.setInt(6,Integer.parseInt(product.getCategory()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert != 0;
    }

    @Override
    public boolean update(int id, Product product) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = SQLConnection.getConnection();
        int rowDelete = 0;
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_PRODUCT);
            callableStatement.setInt(1, id);
            rowDelete = callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete != 0;
    }
}
