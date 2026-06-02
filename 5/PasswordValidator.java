import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        String[] passwords = {"Password123", "weak", "StrongPwd9", "NoDigits", "Short1", "ValidPass1"};
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
        for (String pwd : passwords) {
            Matcher matcher = pattern.matcher(pwd);
            System.out.println(pwd + ": " + (matcher.matches() ? "Valid" : "Invalid"));
        }
    }
}
