import java.sql.Time;

public class ValidParethesis {
 /* 1. Two-Pointer Approach (Optimal: O(n) Time, O(1) Space)

Concept:
Skip non-alphanumeric characters and compare characters from both ends, moving inward.
 */   


    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /*
    2. String Cleaning + Reverse (O(n) Time, O(n) Space)

Concept:
Construct a cleaned, lowercase string keeping only alphanumeric chars, reverse it, and compare.

public boolean isPalindrome(String s) {
    StringBuilder cleaned = new StringBuilder();
    for (char c : s.toCharArray())
        if (Character.isLetterOrDigit(c))
            cleaned.append(Character.toLowerCase(c));
    String str = cleaned.toString();
    return str.equals(cleaned.reverse().toString());
}


3.  Recursive Two-Pointer (O(n) Time, O(n) Space due to recursion)

Concept:
Apply recursion to compare the first and last characters, then move inward.

public boolean isPalindrome(String s) {
    return helper(s, 0, s.length() - 1);
}

private boolean helper(String s, int left, int right) {
    while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
    while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
    if (left >= right) return true;
    if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
        return false;
    return helper(s, left + 1, right - 1);
}

4. Using Regular Expressions & StringBuilder

Concept:
Strip out non-alphanumeric characters using regex and check if it's palindrome via reverse.

public boolean isPalindrome(String s) {
    String filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    return filtered.equals(new StringBuilder(filtered).reverse().toString());
}

5. Simplified Validity Check for Edge-Cases & Null Input

Concept:
Perform quick initial checks and then run two-pointer logic, potentially improving clarity.
    
    */



    
}
