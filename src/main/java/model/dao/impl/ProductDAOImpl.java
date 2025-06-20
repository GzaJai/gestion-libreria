package model.dao.impl;

import model.dao.ProductDAO;
import model.entity.Product;
import util.SQLiteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements ProductDAO {

    private final Connection conn;

    public ProductDAOImpl() {
        this.conn = SQLiteConnection.getConnection();
    }

    @Override
    public void save(Product product) throws Exception {
        String sql = "INSERT INTO product (code, name, description, purchase_price, sell_price, suggested_price, category) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
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
    public boolean update(Product product) throws Exception {
        String sql = """
                UPDATE product SET
                    name = ?,
                    description = ?,
                    purchase_price = ?,
                    sell_price = ?,
                    suggested_price = ?,
                    category = ?
                    WHERE code = ?
               """;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPurchasePrice());
            stmt.setDouble(4, product.getSellPrice());
            stmt.setDouble(5, product.getSuggestedPrice());
            stmt.setString(6, product.getCategory());
            stmt.setLong(7, product.getCode());

            int updatedRows = stmt.executeUpdate();
            return updatedRows > 0;
        } catch (SQLException e) {
            return false;
        }
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
                product.setCode(rs.getLong("code"));
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

    @Override
    public Product findByCode(long code) {
        String sql = "SELECT * FROM product WHERE code = ?";
        Product product = new Product();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, code);
            ResultSet result = stmt.executeQuery();

            if  (result.next()) {
                product.setCode(result.getLong("code"));
                product.setName(result.getString("name"));
                product.setDescription(result.getString("description"));
                product.setPurchasePrice(result.getFloat("purchase_price"));
                product.setSellPrice(result.getFloat("sell_price"));
                product.setSuggestedPrice(result.getFloat("suggested_price"));
                product.setCategory(result.getString("category"));

                return product;
            } else  {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
