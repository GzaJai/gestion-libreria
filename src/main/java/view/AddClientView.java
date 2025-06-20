package view;

import model.dao.ClientDAO;
import model.dao.impl.ClientDAOImpl;
import model.entity.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClientView extends JFrame {
    private JTextField nameInput;
    private JTextField cuitInput;
    private JTextField phoneNumberInput;
    private JTextField cuilInput;
    private JTextField categoryInput;
    private JTextField emailInput;
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField dniInput;
    private JPanel mainPanel;

    public AddClientView() {
        add(mainPanel);
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientDAO clientDAO = new ClientDAOImpl();

                Client newClient = new Client();
                newClient.setName(nameInput.getText());
                if (!dniInput.getText().isEmpty()) {
                    newClient.setDni((Long.parseLong(dniInput.getText())));
                }
                if (!cuitInput.getText().isEmpty()) {
                    newClient.setCuit((Long.parseLong(cuitInput.getText())));
                }
                if (!cuilInput.getText().isEmpty()) {
                    newClient.setCuil((Long.parseLong(cuilInput.getText())));
                }
                newClient.setCategory(categoryInput.getText());
                newClient.setDescription("Default");
                newClient.setEmail(emailInput.getText());
                newClient.setPhoneNumber(Long.parseLong(phoneNumberInput.getText()));

                try {
                    clientDAO.save(newClient);
                    JOptionPane.showMessageDialog(null, "El cliente se agregó correctamente.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro.");
                    System.out.println("Error al agregar cliente" +  ex.getMessage());
                }
            }
        });
    }
}
