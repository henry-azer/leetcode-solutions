package org.henry;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes(nums, 2));

        int[] nums2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(longestOnes(nums2, 3));
    }

    public static int longestOnes(int[] nums, int k) {
        int p = 0, zeroCount = 0, maxOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeroCount++;
            while (zeroCount > k) {
                if (nums[p] == 0) zeroCount--;
                p++;
            }
            maxOnes = Math.max(maxOnes, i - p + 1);
        }
        return maxOnes;
    }
}
