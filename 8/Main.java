import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        createSampleInputFile(inputFile);
        DataManager dm = new DataManager();
        dm.registerDataProcessor(new FilterProcessor());
        dm.registerDataProcessor(new TransformProcessor());
        dm.registerDataProcessor(new AggregateProcessor());
        System.out.println("Loading: " + inputFile);
        dm.loadData(inputFile);
        System.out.println("Original: " + dm.getData());
        System.out.println("Processing...");
        dm.processData();
        System.out.println("Result: " + dm.getData());
        dm.saveData(outputFile);
    }
    private static void createSampleInputFile(String name) {
        List<String> data = Arrays.asList("hello", "world", "java", "programming", "java", "hello");
        try (java.io.PrintWriter w = new java.io.PrintWriter(new java.io.FileWriter(name))) {
            for (String line : data) w.println(line);
            System.out.println("Created: " + name);
        } catch (Exception e) {}
    }
}
