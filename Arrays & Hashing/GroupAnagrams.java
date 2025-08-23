import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// APPROCHES 
// 1) Sorting-based approach

// For each word, sort the characters (e.g., "eat" → "aet").

// Use this sorted string as a key in a hashmap.

// Time: O(n * k log k) (n = words, k = avg length).

// Easy to implement.

// 2) Counting-based approach (Optimized)

// For each word, count frequency of characters (26 length array for lowercase letters).

// Use this count as a key (converted to string/tuple).

// Groups words with the same character counts.

// Time: O(n * k) — faster because no sorting.

// Space: O(n * k) for hashmap keys.

// 3) Prime Hashing approach (rare in interviews)

// Assign each letter a prime number.

// Multiply primes for each word → same product means anagram.

// Risk: integer overflow.

// Not commonly preferred.

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr); // same key for all anagrams
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
    
}
