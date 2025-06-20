package model.dao.impl;

import model.dao.ClientDAO;
import model.entity.Client;
import util.SQLiteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDAOImpl implements ClientDAO {

    @Override
    public void save(Client client) throws Exception {
        String sql = "INSERT INTO client (name, dni, cuit, cuil, category, description, email, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLiteConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setLong(2, client.getDni());
            stmt.setLong(3, client.getCuit());
            stmt.setLong(4, client.getCuil());
            stmt.setString(5, client.getCategory());
            stmt.setString(6, client.getDescription());
            stmt.setString(7, client.getEmail());
            stmt.setLong(8, client.getPhoneNumber());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Client client) throws Exception {

    }

    @Override
    public void delete(long id) throws Exception {

    }

    @Override
    public Optional<Client> findById(long id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Client> findAll() throws Exception {
        String sql = "SELECT * FROM client ORDER BY name";
        List<Client> clients = new ArrayList<>();

        try (Connection conn = SQLiteConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getLong("id"));
                client.setName(rs.getString("name"));
                client.setDni(rs.getLong("dni"));
                client.setCuit(rs.getLong("cuit"));
                client.setCuil(rs.getLong("cuil"));
                client.setCategory(rs.getString("category"));
                client.setDescription(rs.getString("description"));
                client.setEmail(rs.getString("email"));
                client.setPhoneNumber(rs.getLong("phone_number"));

                clients.add(client);
            }
        }
        return clients;
    }
}
