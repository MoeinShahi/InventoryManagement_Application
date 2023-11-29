/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.management;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProductTableModel extends DefaultTableModel {
    private final List<Product> products;

    public ProductTableModel() {
        super(new Object[]{"Product name", "SKU number", "Category", "Quantity"}, 0);
        products = new ArrayList<>();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: // Product name
            case 1: // SKU number
            case 2: // Category
                return String.class;
            case 3: // Quantity
                return Integer.class;
            default:
                return Object.class;
        }
    }

    public void addProduct(Product product) {
        products.add(product);
        addRow(new Object[]{product.getName(), product.getSku(), product.getCategory(), product.getQuantity()});
    }

    public void removeProduct(int rowIndex) {
        products.remove(rowIndex);
        removeRow(rowIndex);
    }

    public Product getProduct(int rowIndex) {
        return products.get(rowIndex);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products); // Return a copy to avoid external modification
    }

    // This method ensures that cells are not editable directly from the table view
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
