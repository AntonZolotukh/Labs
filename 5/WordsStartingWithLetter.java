import java.util.regex.*;

public class WordsStartingWithLetter {
    public static void main(String[] args) {
        char letter = 'b';
        String text = "big brown bear eats blue berries and bananas apple orange";
        Pattern pattern = Pattern.compile("\\b" + letter + "[A-Za-z]*\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
