package util;

import model.dao.ProductDAO;
import model.dao.impl.ProductDAOImpl;
import model.entity.Product;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UploadFromPDF {

    public static void importFromPDF(String filePath) throws IOException {

        ProductDAO productDAO = new ProductDAOImpl();

        int updatedRows = 0;
        int newRows = 0;
        String message = "";

        try {
            String pdfText = readTextFromPDF(filePath);
            List<Product> products = parseProductsFromText(pdfText);

            for (Product product : products) {
                Product existing = productDAO.findByCode(product.getCode());

                if (existing == null) {
                    productDAO.save(product);
                    newRows++;
                } else if (existing.getSuggestedPrice() != product.getSuggestedPrice()) {
                    productDAO.update(product);
                    updatedRows++;
                }
            }
            if (updatedRows > 0) {
                message += "se actualizaron "  + updatedRows + " productos\n";
            }
            if (newRows > 0) {
                message += "se agregaron " + newRows + " productos";
            }
            if (newRows == 0 && updatedRows == 0) {
                message = "No se actualizaron ni se agregaron productos";
            }

            JOptionPane.showMessageDialog(null, message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static String readTextFromPDF(String filePath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            return stripper.getText(document);
        }
    }

    public static List<Product> parseProductsFromText(String text) {
        List<Product> products = new ArrayList<>();

        Pattern pattern = Pattern.compile(
        "^\\S+\\s+(\\d{13})\\s+(.+?)\\s+(\\d{1,3}(?:\\.\\d{3})*,\\d{2})\\s+(\\d{1,3}(?:\\.\\d{3})*,\\d{2})$"
        );

        for (String line : text.split("\\r?\\n")) {
            Matcher matcher = pattern.matcher(line);
            if (!matcher.find()) {
                continue;
            }

            String barcode = matcher.group(1);
            String name = matcher.group(2).trim();
            String suggestedPriceStr = matcher.group(3).replace(".", "").replace(",", ".");
            String sellPriceStr = matcher.group(4).replace(".", "").replace(",", ".");

            try {
                Product product = new Product();
                product.setCode(Long.parseLong(barcode));
                product.setName(name);
                product.setSuggestedPrice(Float.parseFloat(suggestedPriceStr));
                product.setPurchasePrice(Float.parseFloat(sellPriceStr));

                products.add(product);
            } catch (NumberFormatException ex) {
                System.err.println("Error parsing product code: " + line);
            }
        }
        return products;
    }
}
