package inventory.management;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;

public class ProductTableModelTest {

    @Test
    public void testAddProduct() {
        // Arrange
        ProductTableModel productTableModel = new ProductTableModel();
        Product product = new Product("Test Product", "SKU123", "Test Category", 10);

        // Act
        productTableModel.addProduct(product);

        // Assert
        assertEquals(1, productTableModel.getRowCount());
        assertEquals(product, productTableModel.getProduct(0));
    }

    @Test
    public void testRemoveProduct() {
        // Arrange
        ProductTableModel productTableModel = new ProductTableModel();
        Product product = new Product("Test Product", "SKU123", "Test Category", 10);
        productTableModel.addProduct(product);

        // Act
        productTableModel.removeProduct(0);

        // Assert
        assertEquals(0, productTableModel.getRowCount());
    }

    @Test
    public void testGetProduct() {
        // Arrange
        ProductTableModel productTableModel = new ProductTableModel();
        Product product = new Product("Test Product", "SKU123", "Test Category", 10);
        productTableModel.addProduct(product);

        // Act
        Product retrievedProduct = productTableModel.getProduct(0);

        // Assert
        assertEquals(product, retrievedProduct);
    }

    @Test
    public void testGetAllProducts() {
        // Arrange
        ProductTableModel productTableModel = new ProductTableModel();
        Product product1 = new Product("Product 1", "SKU1", "Category 1", 5);
        Product product2 = new Product("Product 2", "SKU2", "Category 2", 8);
        productTableModel.addProduct(product1);
        productTableModel.addProduct(product2);

        // Act
        java.util.List<Product> allProducts = productTableModel.getAllProducts();

        // Assert
        assertEquals(2, allProducts.size());
        assertEquals(product1, allProducts.get(0));
        assertEquals(product2, allProducts.get(1));
    }

    @Test
    public void testIsCellEditable() {
        // Arrange
        ProductTableModel productTableModel = new ProductTableModel();

        // Act & Assert
        assertFalse(productTableModel.isCellEditable(0, 0));
    }

    @After
    public void cleanup() {
        // Clean up after each test
        deleteTestFile();
    }

    private void deleteTestFile() {
        File testFile = new File("testfile.dat");
        if (testFile.exists()) {
            testFile.delete();
        }
    }
}
