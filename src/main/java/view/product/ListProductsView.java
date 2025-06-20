package view.product;

import model.dao.ProductDAO;
import model.dao.impl.ProductDAOImpl;
import model.entity.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListProductsView extends JPanel {
    private JTable productsTable;
    private JPanel mainPanel;

    private final ProductDAO productDAO =  new ProductDAOImpl();

    public ListProductsView() {
        add(mainPanel);
        loadProductData();
    }

    private void loadProductData() {
        String[] columnNames = {"Código", "Nombre", "Descripción", "Precio compra", "Precio Sugerido", "Precio venta", "Categoria"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        try {
            List<Product> products = productDAO.findAll();
            for (Product p : products) {
                Object[] row = {
                        p.getCode(),
                        p.getName(),
                        p.getDescription(),
                        p.getPurchasePrice(),
                        p.getSuggestedPrice(),
                        p.getSellPrice(),
                        p.getCategory()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los productos");
        }
        productsTable.setModel(model);
    }
}
