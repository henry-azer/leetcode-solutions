package org.henry;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 5, 6, 2, 2, 7, 7, 8};
        int k = removeElement(nums, 2);
        System.out.println(k + ", nums = " + Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int k = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 101;
                k -= 1;
            }
        }
        Arrays.sort(nums);
        return k;
    }
}
