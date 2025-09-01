package NEETCODE_150.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    /*
     * class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}

HashSet (O(n²))

Idea: Fix one number nums[i] and solve the 2Sum problem for the rest.

Steps:

Loop over i

Use a HashSet to track required complement for nums[j]

If found, we have a triplet.

Sort before adding to result to avoid permutations.

Complexity:

Time = O(n²)

Space = O(n)


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i+1; j < n; j++) {
                int target = -(nums[i] + nums[j]);
                if (set.contains(target)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], target);
                    Collections.sort(triplet);    //USED COLLECTIONS INSTED OF ARRAYS.SORT ??////
                    result.add(triplet);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(result);
    }
}


Approach 3: Sorting + Two Pointers (O(n²))

Idea:

Sort the array.

Loop i from 0 → n-3

Use two pointers (l = i+1, r = n-1)

If nums[i] + nums[l] + nums[r] == 0, add triplet.

Move pointers carefully to skip duplicates.

Complexity:

Time = O(n²)

Space = O(1) (ignoring result).

     */

    class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; // skip duplicate i
            int l = i+1, r = n-1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l-1]) l++; // skip duplicate left
                    while (l < r && nums[r] == nums[r+1]) r--; // skip duplicate right
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}

}
