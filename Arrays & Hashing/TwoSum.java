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
