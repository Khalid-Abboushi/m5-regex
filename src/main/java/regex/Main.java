package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        final String userInput = scanner.nextLine();
        scanner.close();
        System.out.println("You entered \"" + userInput + "\"");
        System.out.println(checkForPassword(userInput, 6));
        System.out.println(extractEmails(userInput));
        System.out.println(checkForDoubles(userInput));
    }

    /**
     * Returns whether a string is non-empty, contains lowercase,
     * uppercase, digit, and meets minLength.
     */
    public static boolean checkForPassword(String str, int minLength) {
        if (str == null) {
            return false;
        }
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{" + minLength + ",}$";
        return Pattern.matches(regex, str);
    }

    /**
     * Returns list of emails ending with @utoronto.ca or @mail.utoronto.ca.
     */
    public static List<String> extractEmails(String str) {
        final List<String> result = new ArrayList<>();
        if (str == null) {
            return result;
        }

        final Pattern pattern =
                Pattern.compile("[A-Za-z0-9._%+-]+@(mail\\.)?utoronto\\.ca");
        final Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }

    /**
     * Checks whether str contains the same capital letter twice.
     */
    public static boolean checkForDoubles(String str) {
        if (str == null) {
            return false;
        }
        return str.matches(".*([A-Z]).*\\1.*");
    }
}
