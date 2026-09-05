package week4.class_problems;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] result1 = twoSum(nums1, 9);
        System.out.println(Arrays.toString(result1));
        
        int[] nums2 = {3, 2, 4};
        int[] result2 = twoSum(nums2, 6);
        System.out.println(Arrays.toString(result2));
    }
}
