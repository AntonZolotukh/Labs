import java.util.*;

public class SalesTracker {
    private TreeMap<String, Integer> salesMap;

    public SalesTracker() {
        salesMap = new TreeMap<>();
    }

    public void addSale(String productName) {
        salesMap.put(productName, salesMap.getOrDefault(productName, 0) + 1);
    }

    public void printSoldProducts() {
        System.out.println("Список проданных товаров (товар -> количество):");
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public int getTotalSales() {
        int total = 0;
        for (int count : salesMap.values()) {
            total += count;
        }
        return total;
    }

    public String getMostPopularProduct() {
        String mostPopular = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        return mostPopular;
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        tracker.addSale("Яблоко");
        tracker.addSale("Банан");
        tracker.addSale("Яблоко");
        tracker.addSale("Апельсин");
        tracker.addSale("Банан");
        tracker.addSale("Банан");

        tracker.printSoldProducts();
        System.out.println("Общая сумма продаж: " + tracker.getTotalSales());
        System.out.println("Наиболее популярный товар: " + tracker.getMostPopularProduct());
    }
}
