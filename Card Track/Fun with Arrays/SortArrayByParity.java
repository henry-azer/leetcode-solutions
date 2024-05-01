package org.henry;

import java.util.Arrays;

public class SortArrayByParity {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(sortArrayByParity2(nums2)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        int[] result = new int[nums.length];
        for (int num : nums) {
            if (num % 2 == 0) result[l++] = num;
            else result[r--] = num;
        }
        return result;
    }

    public static int[] sortArrayByParity2(int[] nums) {
        if (nums.length <= 1) return nums;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] % 2 != 0 && nums[r] % 2 == 0) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
            } else if (nums[l] % 2 == 0) l++;
            else if (nums[r] % 2 != 0) r--;
        }
        return nums;
    }
}
