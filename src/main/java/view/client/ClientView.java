package view.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientView extends JPanel {
    private JButton addClientButton;
    private JPanel mainPanel;
    private JButton listClientsButton;

    public ClientView() {
        add(mainPanel);


        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddClientView  addClientView = new AddClientView();
                addClientView.setVisible(true);
            }
        });
        listClientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListClientsView  listClientsView = new ListClientsView();
                listClientsView.setVisible(true);
            }
        });
    }
}
