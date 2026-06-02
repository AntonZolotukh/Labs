public class PhoneBook {
    public static void main(String[] args) {
        HashTable<String, Contact> phoneBook = new HashTable<>();

        Contact contact1 = new Contact("John Doe", "john@example.com", "Friend from work");
        Contact contact2 = new Contact("Jane Smith", "jane@example.com", "University colleague");
        Contact contact3 = new Contact("Bob Johnson", "bob@example.com", "Brother");

        phoneBook.put("+79123456789", contact1);
        phoneBook.put("+79998887766", contact2);
        phoneBook.put("+79551112233", contact3);

        System.out.println("=== Phone Book ===");
        System.out.println("Size: " + phoneBook.size());

        System.out.println("\nSearch for +79123456789:");
        System.out.println(phoneBook.get("+79123456789"));

        System.out.println("\nRemoving +79551112233...");
        phoneBook.remove("+79551112233");

        System.out.println("Size after removal: " + phoneBook.size());

        System.out.println("\nSearch for removed contact:");
        System.out.println(phoneBook.get("+79551112233"));
    }
}
