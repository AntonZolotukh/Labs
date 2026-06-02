import java.util.regex.*;

public class c {
    public static void main(String[] args) {
        String text = "aBc dEf gHi jKl mM nOo pPq rRs sTt uUv";
        Pattern pattern = Pattern.compile("([a-z])([A-Z])");
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll("!$1$2!");
        System.out.println(result);
    }
}
