package inventory.management;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testProductInitialization() {
        // Arrange
        String name = "TestProduct";
        String sku = "SKU001";
        String category = "TestCategory";
        int quantity = 10;

        // Act
        Product product = new Product(name, sku, category, quantity);

        // Assert
        assertEquals(name, product.getName());
        assertEquals(sku, product.getSku());
        assertEquals(category, product.getCategory());
        assertEquals(quantity, product.getQuantity());
    }

    @Test
    public void testSetName() {
        // Arrange
        Product product = new Product("InitialName", "SKU002", "TestCategory", 5);

        // Act
        product.setName("UpdatedName");

        // Assert
        assertEquals("UpdatedName", product.getName());
    }

    @Test
    public void testSetSku() {
        // Arrange
        Product product = new Product("TestProduct", "InitialSKU", "TestCategory", 5);

        // Act
        product.setSku("UpdatedSKU");

        // Assert
        assertEquals("UpdatedSKU", product.getSku());
    }

    @Test
    public void testSetCategory() {
        // Arrange
        Product product = new Product("TestProduct", "SKU003", "InitialCategory", 5);

        // Act
        product.setCategory("UpdatedCategory");

        // Assert
        assertEquals("UpdatedCategory", product.getCategory());
    }

    @Test
    public void testSetQuantity() {
        // Arrange
        Product product = new Product("TestProduct", "SKU004", "TestCategory", 5);

        // Act
        product.setQuantity(15);

        // Assert
        assertEquals(15, product.getQuantity());
    }

    @After
    public void cleanup() {
        // Clean up after each test
    }
}
