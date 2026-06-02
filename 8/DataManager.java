import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class DataManager {
    private List<String> data;
    private List<Object> processors = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void processData() {
        if (data == null || data.isEmpty()) {
            System.out.println("No data");
            return;
        }
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<CompletableFuture<List<String>>> futures = new ArrayList<>();
        for (Object processor : processors) {
            CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> {
                List<String> result = new ArrayList<>(data);
                for (Method method : processor.getClass().getDeclaredMethods()) {
                    if (method.isAnnotationPresent(DataProcessor.class)) {
                        try {
                            result = (List<String>) method.invoke(processor, result);
                        } catch (Exception e) {}
                    }
                }
                return result;
            }, executor);
            futures.add(future);
        }
        data = futures.stream().map(f -> {
            try { return f.get(5, TimeUnit.SECONDS); }
            catch (Exception e) { return new ArrayList<String>(); }
        }).flatMap(List::stream).collect(Collectors.toList());
        executor.shutdown();
    }

    public void saveData(String destination) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Saved: " + destination);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public List<String> getData() {
        return data;
    }
}
