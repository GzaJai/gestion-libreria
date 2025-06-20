package view.product;

import model.dao.ProductDAO;
import model.dao.impl.ProductDAOImpl;
import model.entity.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addProductView extends JPanel {
    private JTextField codeInputField;
    private JTextField descriptionInputField;
    private JTextField purchasePriceInputField;
    private JTextField sellPriceInputField;
    private JTextField suggestedPriceInputField;
    private JTextField categoryInputField;
    private JButton saveProductButton;
    private JPanel mainPanel;
    private JTextField nameInputField;

    public addProductView() {
        add(mainPanel);
        saveProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               guardarProducto();
            }
        });
    }

    private void guardarProducto () {
        ProductDAO productDAO =  new ProductDAOImpl();
        Product newProduct = new Product();

        newProduct.setCode(Long.parseLong(codeInputField.getText()));
        newProduct.setName(nameInputField.getText());
        if (!descriptionInputField.getText().isEmpty()) {
            newProduct.setDescription(descriptionInputField.getText());
        }
        newProduct.setPurchasePrice(Float.parseFloat(purchasePriceInputField.getText()));
        newProduct.setSellPrice(Float.parseFloat(sellPriceInputField.getText()));
        if (!suggestedPriceInputField.getText().isEmpty()) {
            newProduct.setSuggestedPrice(Float.parseFloat(suggestedPriceInputField.getText()));
        }
        newProduct.setCategory(categoryInputField.getText());

        try {
            productDAO.save(newProduct);
            JOptionPane.showMessageDialog(this, "Producto guardado exitosamente");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error guardando producto");
            System.out.println("Error al guardar el producto:" + ex.getMessage());
        }
    }
}
