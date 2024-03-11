package org.henry;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, temp = 0;
        for (var num : nums) {
            if (num == 1) {
                temp += 1;
            } else {
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        return Math.max(max, temp);
    }
}
