import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WarehouseTransfer {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addItem(new Item("Товар1", 30));
        warehouse.addItem(new Item("Товар2", 45));
        warehouse.addItem(new Item("Товар3", 20));
        warehouse.addItem(new Item("Товар4", 60));
        warehouse.addItem(new Item("Товар5", 25));
        warehouse.addItem(new Item("Товар6", 40));
        warehouse.addItem(new Item("Товар7", 15));

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            final int loaderId = i + 1;
            CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                System.out.println("Грузчик " + loaderId + " начал работу");
                return warehouse.loadItems(150);
            }, executor).thenAcceptAsync(items -> {
                System.out.println("Грузчик " + loaderId + " несёт: " + items);
                warehouse.unloadItems(items);
                System.out.println("Грузчик " + loaderId + " доставил товары");
            }, executor);

            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executor.shutdown();
        System.out.println("Все товары перенесены. Остаток на складе: " + warehouse.getRemainingWeight());
    }
}

class Item {
    String name;
    int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + "(" + weight + "кг)";
    }
}

class Warehouse {
    private final List<Item> items = new ArrayList<>();
    private final Object lock = new Object();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> loadItems(int maxWeight) {
        List<Item> loaded = new ArrayList<>();
        synchronized (lock) {
            int currentWeight = 0;
            var iterator = items.iterator();
            while (iterator.hasNext()) {
                Item item = iterator.next();
                if (currentWeight + item.weight <= maxWeight) {
                    currentWeight += item.weight;
                    loaded.add(item);
                    iterator.remove();
                }
                if (currentWeight == maxWeight) break;
            }
        }
        return loaded;
    }

    public void unloadItems(List<Item> items) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getRemainingWeight() {
        synchronized (lock) {
            return items.stream().mapToInt(i -> i.weight).sum();
        }
    }
}
