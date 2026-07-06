import java.util.Scanner;

public class RegularExpressionMatching {

    static String checkMatch(String text, String pattern) {

        // Pattern should not start or end with '+'
        if (pattern.startsWith("+") || pattern.endsWith("+")) {
            return "Invalid Pattern";
        }

        // Two '+' together are also invalid
        if (pattern.contains("++")) {
            return "Invalid Pattern";
        }

        int i = 0;
        int j = 0;

        while (i < text.length() && j < pattern.length()) {

            // Check if next character in pattern is '+'
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '+') {

                char current = pattern.charAt(j);

                // At least one occurrence is required
                if (i >= text.length() || text.charAt(i) != current) {
                    return "False";
                }

                // Match all repeated characters
                while (i < text.length() && text.charAt(i) == current) {
                    i++;
                }

                j += 2;
            } else {

                // Normal character comparison
                if (i >= text.length() || text.charAt(i) != pattern.charAt(j)) {
                    return "False";
                }

                i++;
                j++;
            }
        }
// If pattern ends but text still remains 
if(j>= pattern.length() && i<text.length()) {
    return "False";
}

        // Both text and pattern should finish together
        if (i == text.length() && j == pattern.length()) {
            return "True";
        }

        return "False";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String P: ");
        String p = sc.next();

        System.out.print("Enter Pattern Q: ");
        String q = sc.next();

        System.out.println("Result: " + checkMatch(p, q));

        sc.close();
    }
}