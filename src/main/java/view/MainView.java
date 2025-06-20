package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JPanel mainPanel;
    private JButton invoiceButton;
    private JButton quoteButton;
    private JButton clientButton;
    private JButton productButton;
    private JPanel navBarPanel;
    private JPanel contentPanel;
    private JPanel clientPanel;
    private JPanel productPanel;
    private JPanel invoicePanel;
    private JPanel quotePanel;

    private CardLayout cardLayout;

    public MainView() {
        add(mainPanel);
        setTitle("Gestion Libreria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800,600);
        setVisible(true);

        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        clientPanel = new ClientView();

        contentPanel.add(invoicePanel, "Invoice");
        contentPanel.add(quotePanel, "Quote");
        contentPanel.add(clientPanel, "Client");
        contentPanel.add(productPanel, "Product");

        invoiceButton.addActionListener(e -> cardLayout.show(contentPanel, "Invoice"));
        quoteButton.addActionListener(e -> cardLayout.show(contentPanel, "Quote"));
        clientButton.addActionListener(e -> cardLayout.show(contentPanel, "Client"));
        productButton.addActionListener(e -> cardLayout.show(contentPanel, "Product"));
    }

}
