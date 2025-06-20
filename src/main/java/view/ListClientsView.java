package view;

import model.dao.impl.ClientDAOImpl;
import model.dao.ClientDAO;
import model.entity.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListClientsView extends JFrame {
    private JTable clientsTable;
    private JPanel mainPanel;

    private final ClientDAO clientDAO = new ClientDAOImpl();

    public ListClientsView() {
        add(mainPanel);
        setTitle("Lista de Clientes");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        loadClientData();
        setVisible(true);

    }

    private void loadClientData() {
        String[] columnNames = {"ID", "Nombre", "DNI", "CUIT", "CUIL", "Categoría", "Descripción", "Email", "Teléfono"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        try {
            List<Client> clients = clientDAO.findAll();
            for (Client c : clients) {
                Object[] row = {
                        c.getId(),
                        c.getName(),
                        c.getDni(),
                        c.getCuil(),
                        c.getCuil(),
                        c.getCategory(),
                        c.getDescription(),
                        c.getEmail(),
                        c.getPhoneNumber()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al obtener los datos");
        }

        clientsTable.setModel(model);
    }
}
