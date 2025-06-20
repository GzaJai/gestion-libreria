package model.dao;

import model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    void save(Product product) throws Exception;
    boolean update(Product product) throws Exception;
    void delete(long id) throws Exception;
    Optional<Product> findById(long id) throws Exception;
    List<Product> findAll() throws Exception;
    Product findByCode(long code) throws Exception;
    boolean itExists();
}
