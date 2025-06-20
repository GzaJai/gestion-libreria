package view;

import view.client.ClientView;
import view.product.ProductView;

import javax.swing.*;
import java.awt.*;

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
    private final ImageIcon imgIcon = new  ImageIcon("C:/Users/Usuario/Documents/Desarrollo/Aplicaciones/Gestion Libreria/gestion-libreria/src/main/resources/administrar.png");

    public MainView() {
        add(mainPanel);
        setTitle("Gestion Libreria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(imgIcon.getImage());

        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);



        clientPanel = new ClientView();
        productPanel = new ProductView();

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
