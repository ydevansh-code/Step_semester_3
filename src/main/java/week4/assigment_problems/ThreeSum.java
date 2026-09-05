package week4.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});
                    left++;
                    right--;
                    
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return resultList.toArray(new int[0][0]);
    }
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] res1 = threeSum(nums1);
        System.out.println(Arrays.deepToString(res1));
        
        int[] nums2 = {0, 0, 0};
        int[][] res2 = threeSum(nums2);
        System.out.println(Arrays.deepToString(res2));
    }
}
