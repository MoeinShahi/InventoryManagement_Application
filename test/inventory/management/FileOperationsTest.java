package inventory.management;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileOperationsTest {

    private static final String TEST_FILE_PATH = "testfile.dat";

    @Test
    public void saveDataAndLoadData() {
        // Arrange
        List<Product> testData = createTestData();

        // Act
        FileOperations.saveData(TEST_FILE_PATH, testData);
        List<Product> loadedData = FileOperations.loadData(TEST_FILE_PATH);

        // Assert
        assertEquals(testData.size(), loadedData.size());
        for (int i = 0; i < testData.size(); i++) {
            assertProductEquals(testData.get(i), loadedData.get(i));
        }
    }

    @Test
    public void loadDataFromNonexistentFile() {
        // Act
        List<Product> loadedData = FileOperations.loadData("nonexistentfile.dat");

        // Assert
        assertNotNull(loadedData);
        assertTrue(loadedData.isEmpty());
    }

    @After
    public void cleanup() {
        // Clean up
        deleteTestFile();
    }

    private List<Product> createTestData() {
        List<Product> testData = new ArrayList<>();
        testData.add(new Product("TestProduct1", "SKU001", "Category1", 10));
        testData.add(new Product("TestProduct2", "SKU002", "Category2", 20));
        // Add more test data as needed
        return testData;
    }

    private void assertProductEquals(Product expected, Product actual) {
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getSku(), actual.getSku());
        assertEquals(expected.getCategory(), actual.getCategory());
        assertEquals(expected.getQuantity(), actual.getQuantity());
    }

    private void deleteTestFile() {
        File testFile = new File(TEST_FILE_PATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }
}
