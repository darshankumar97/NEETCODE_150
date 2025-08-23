
// All Approaches
// 1. Sorting Approach

// Steps:

// If lengths of s and t differ → return false.

// Convert both strings into character arrays.

// Sort both arrays.

// Compare sorted arrays → if equal, return true.

// Time Complexity: O(n log n) (due to sorting)
// Space Complexity: O(1) or O(n) depending on sorting implementation.

// 2. HashMap (Frequency Count)

// Steps:

// If lengths differ → return false.

// Use a HashMap<Character, Integer> to count frequency of each character in s.

// Traverse t and decrement the frequency in the map.

// If any count becomes negative or extra characters appear → return false.

// If all counts are zero → return true.

// Time Complexity: O(n)
// Space Complexity: O(k) where k = number of unique characters.

// 3. Fixed-Size Array (Best for lowercase English letters)

// Steps:

// If lengths differ → return false.

// Create an integer array of size 26.

// For each character in s, increment the count.

// For each character in t, decrement the count.

// If all counts in the array are zero → return true, else false.

// Time Complexity: O(n)
// Space Complexity: O(1) (constant space: array of size 26).
// 👉 This is the most optimal solution.

public class ValidAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            
            int[] count = new int[26]; // for lowercase English letters
            
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                count[t.charAt(i) - 'a']--;
            }
            
            for (int c : count) {
                if (c != 0) return false;
            }
            
            return true;
        }
    }
    
}
