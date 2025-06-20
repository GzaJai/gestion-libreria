package view.product;

import util.UploadFromPDF;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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
        uploadFromPDFButton.addActionListener(e -> {
            try {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Selecciona un archivo PDF");
                fileChooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
                fileChooser.setFileFilter(filter);

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    UploadFromPDF.importFromPDF(file.getAbsolutePath());
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
