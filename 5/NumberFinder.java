import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $19.99 and 100 items cost $1999.50";
        Pattern pattern = Pattern.compile("\\d+\\.\\d+|\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
