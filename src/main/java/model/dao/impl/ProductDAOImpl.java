package model.dao.impl;

import model.dao.ProductDAO;
import model.entity.Product;
import util.SQLiteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public void save(Product product) throws Exception {
        String sql = "INSERT INTO product (code, name, description, purchase_price, sell_price, suggested_price, category) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLiteConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, product.getCode());
            stmt.setString(2, product.getName());
            stmt.setString(3, product.getDescription());
            stmt.setDouble(4, product.getPurchasePrice());
            stmt.setDouble(5, product.getSellPrice());
            stmt.setDouble(6, product.getSuggestedPrice());
            stmt.setString(7, product.getCategory());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Product product) throws Exception {

    }

    @Override
    public void delete(long id) throws Exception {

    }

    @Override
    public Optional<Product> findById(long id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() throws Exception {
        String sql = "SELECT * FROM product";
        List<Product> products = new ArrayList<>();

        try (Connection conn = SQLiteConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setCode(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPurchasePrice(rs.getFloat("purchase_price"));
                product.setSellPrice(rs.getFloat("sell_price"));
                product.setSuggestedPrice(rs.getFloat("suggested_price"));
                product.setCategory(rs.getString("category"));

                products.add(product);
            }
        }

        return products;
    }
}
