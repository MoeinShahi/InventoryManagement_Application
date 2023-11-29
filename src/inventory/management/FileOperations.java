package inventory.management;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileOperations {

    public static void saveData(String filename, List<Product> products) {
        try (FileOutputStream file = new FileOutputStream(filename); ObjectOutputStream output = new ObjectOutputStream(file)) {
            output.writeObject(products);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Product> loadData(String filename) {
        File file = new File(filename);

        // If the file does not exist, create it
        if (!file.exists()) {
            try {
                file.createNewFile();
                return new ArrayList<>(); // Return an empty list for a new file
            } catch (IOException ex) {
                ex.printStackTrace();
                return new ArrayList<>(); // Return an empty list if there's an error creating the file
            }
        }

        // If the file is empty, return an empty list
        if (file.length() == 0) {
            return new ArrayList<>();
        }

        try (FileInputStream fileStream = new FileInputStream(file); ObjectInputStream input = new ObjectInputStream(fileStream)) {
            return (List<Product>) input.readObject();
        } catch (EOFException ex) {
            ex.printStackTrace();
            return new ArrayList<>(); // Return an empty list if the file is empty
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return new ArrayList<>(); // Return an empty list if there's an error
        }
    }

    public static List<String[]> readDataFromCSV(String filePath) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return data;
    }
}
