package ACS_567_HWK;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
public class DataEncapsulation {
    DataEncapsulation(){

   
    try {
        
        writeAndReadFile( "");
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
    



}
    
    
    public static void writeAndReadFile(String content) throws IOException {
        Path filePath = Path.of("data.txt");

        // Create the file if it doesn't exist
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        // Append content to the file using StandardOpenOption.APPEND
        Files.write(filePath, content.getBytes(), StandardOpenOption.APPEND);
        System.out.println("Data appended to the file.");
       
    }

    public static void readAllData() throws IOException  {
          Path filePath = Path.of("data.txt");
         if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
        List<String> readContent = Files.readAllLines(filePath);
        System.out.println("File content: " + readContent);
    }

    public static void deleteLineFromFile(int lineNumber) throws IOException {
        Path filePath = Paths.get("data.txt");

        // Read all lines from the file
        List<String> lines = Files.readAllLines(filePath);

        // Check if the line number is valid
        if (lineNumber >= 1 && lineNumber <= lines.size()) {
            // Remove the specified line
            lines.remove(lineNumber - 1);

            // Write the updated content back to the file
            Files.write(filePath, lines);

            System.out.println("Line " + lineNumber + " deleted successfully.");
        } else {
            System.out.println("Invalid line number. No changes made.");
        }
    



    }
   public static void insertLineToFile(int lineNumber, String newLine) throws IOException {
        Path filePath = Paths.get("data.txt");

        // Read all lines from the file
        List<String> lines = Files.readAllLines(filePath);

        // Check if the line number is valid
        if (lineNumber >= 1 && lineNumber <= lines.size() + 1) {
            // Insert the new line at the specified position
            lines.add(lineNumber - 1, newLine);

            // Write the updated content back to the file
            Files.write(filePath, lines);

            System.out.println("Line inserted successfully.");
        } else {
            System.out.println("Invalid line number. No changes made.");
        }
    }



      public static void readAllDataInIOrder(String order) throws IOException {
        Path filePath = Path.of("data.txt");

        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        List<String> readContent = Files.readAllLines(filePath);

        // Display the content in the specified order
        if ("ascending".equalsIgnoreCase(order)) {
            Collections.sort(readContent);
        } else if ("descending".equalsIgnoreCase(order)) {
            Collections.sort(readContent, Collections.reverseOrder());
        } else {
            System.out.println("Invalid order specified. Displaying content in original order.");
        }

        System.out.println("File content in " + order + " order: " + readContent);
    }

     public static void calculateMean() throws IOException {
        Path filePath = Paths.get("data.txt");

        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        List<String> readContent = Files.readAllLines(filePath);

        // Extract numerical values from the file content
        List<Double> numericValues = readContent.stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        // Calculate the mean
        double sum = numericValues.stream().mapToDouble(Double::doubleValue).sum();
        double mean = sum / numericValues.size();

        System.out.println("Mean of the data: " + mean);
    }


    public static void calculateMedian() throws IOException {
        Path filePath = Paths.get("data.txt");

        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        List<String> readContent = Files.readAllLines(filePath);

        // Extract numerical values from the file content
        List<Double> numericValues = readContent.stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        // Sort the values
        numericValues.sort(Double::compareTo);

        // Calculate the median
        int size = numericValues.size();
        double median;

        if (size % 2 == 0) {
            // If even number of elements, average the two middle values
            median = (numericValues.get(size / 2 - 1) + numericValues.get(size / 2)) / 2.0;
        } else {
            // If odd number of elements, take the middle value
            median = numericValues.get(size / 2);
        }

        System.out.println("Median of the data: " + median);
    }
}