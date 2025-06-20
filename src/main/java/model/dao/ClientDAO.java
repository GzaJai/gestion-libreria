package model.dao;

import model.entity.Client;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ClientDAO {
    void save(Client client) throws Exception;
    void update(Client client) throws Exception;
    void delete(long id) throws Exception;
    Optional<Client> findById(long id) throws Exception;
    List<Client> findAll() throws Exception;
}
