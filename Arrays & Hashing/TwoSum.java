import java.util.HashMap;
import java.util.Arrays;


/*
1> Initialize HashMap to store number → index.

2>Loop through array using index i.

3 > Calculate complement:
complement = target - nums[i]

4> Check if complement exists in map:

If yes → return [map.get(complement), i]

5> If not found, add current number to map:
map.put(nums[i], i)

6 > Return empty array if no pair found.

In main method:

Define nums[] and target.

Call twoSum(nums, target).

Print result using Arrays.toString().*/

// approach 1: Brute Force

// Steps:

// Loop through each element in the array (index i).

// For each element, loop again through the rest of the array (index j > i).

// Check if nums[i] + nums[j] == target.

// If yes, return [i, j].

// If no pair found, return [-1, -1].

// Time Complexity: O(n²)
// Space Complexity: O(1)

// 🔹 Approach 2: Sorting + Two Pointers

// (⚠️ But note: indices get messed up, so usually not preferred for LeetCode 1 unless we store original indices.)

// Steps:

// Pair each element with its index.

// Sort the array based on values.

// Use two pointers (left = 0, right = n-1).

// While left < right:

// If nums[left] + nums[right] == target → return their original indices.

// If sum < target → move left++.

// If sum > target → move right--.

// Time Complexity: O(n log n) (due to sorting)
// Space Complexity: O(n) (to keep original indices)

// 🔹 Approach 3: HashMap (Best / Optimized)

// Steps:

// Create a HashMap (value → index).

// Iterate through array with index i.

// For each nums[i]:

// Compute complement = target - nums[i].

// If complement is already in the map → return [map.get(complement), i].

// Otherwise, store nums[i] in map as {nums[i] : i}.

// If no pair found, return [-1, -1].

// Time Complexity: O(n)
// Space Complexity: O(n)

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return new int[] {};  // Return empty array if no solution
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};  // predefined input
        int target = 9;

        int[] result = twoSum(nums, target);
        if(result.length == 2) {
            System.out.println("Indices: " + Arrays.toString(result));
        } else {
            System.out.println("No valid pair found.");
        }
    }
}
