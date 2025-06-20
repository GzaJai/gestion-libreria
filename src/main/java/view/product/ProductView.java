package view.product;

import javax.swing.*;
import java.awt.*;

public class ProductView extends JPanel {
    private JPanel mainPanel;
    private JButton listProductsButton;
    private JButton uploadFromPDFButton;
    private JButton addProductButton;
    private JPanel contentPanel;
    private JPanel navBarPanel;

    private CardLayout cardLayout;
    private JPanel addProductPanel;
    private JPanel listProductsPanel;

    public ProductView() {
        add(mainPanel);


        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        addProductPanel = new addProductView();
        listProductsPanel = new ListProductsView();

        contentPanel.add(addProductPanel, "Add Product");
        contentPanel.add(listProductsPanel, "List Product");

        addProductButton.addActionListener(e -> cardLayout.show(contentPanel, "Add Product"));
        listProductsButton.addActionListener(e -> cardLayout.show(contentPanel, "List Product"));
    }
}
