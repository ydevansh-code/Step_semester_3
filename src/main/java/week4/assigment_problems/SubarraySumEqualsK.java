package week4.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            if (prefixSums.containsKey(currentSum - k)) {
                count += prefixSums.get(currentSum - k);
            }
            
            prefixSums.put(currentSum, prefixSums.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        System.out.println(subarraySum(nums1, 2));
        
        int[] nums2 = {1, -1, 0};
        System.out.println(subarraySum(nums2, 0));
    }
}
