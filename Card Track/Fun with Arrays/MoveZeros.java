package org.henry;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {17, 0, 5, 2, 0, 4, 6, 1};
        moveZeroes(nums);
        System.out.println(Arrays.toString((nums)));

        int[] nums2 = {17, 0, 5, 2, 0, 4, 6, 1};
        moveZeroes2(nums2);
        System.out.println(Arrays.toString((nums2)));
    }

    public static void moveZeroes(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int zerosCount = 0;
        for (int num : nums) {
            if (num != 0) queue.add(num);
            else zerosCount++;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((nums.length - zerosCount) > i) nums[i] = queue.remove();
            else nums[i] = 0;
        }
    }

    public static void moveZeroes2(int[] nums) {
        int nonZeroIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[nonZeroIndex++] = num;
            }
        }
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }
    }
}
