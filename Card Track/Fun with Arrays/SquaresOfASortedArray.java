package org.henry;

import java.util.Arrays;

public class SquaresOfASortedArray {


    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
        System.out.println(Arrays.toString(sortedSquares2(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0, r = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i -= 1) {
            int lp = nums[l] * nums[l];
            int rp = nums[r] * nums[r];

            if (lp > rp) {
                result[i] = lp;
                l++;
            } else {
                result[i] = rp;
                r--;
            }

        }
        return result;
    }

    public static int[] sortedSquares2(int[] nums) {
        for (int i = 0; i < nums.length; i += 1) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
