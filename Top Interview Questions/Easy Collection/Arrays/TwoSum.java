package org.henry;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = {13, 2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum1(nums, 9)));
        System.out.println(Arrays.toString(twoSum2(nums, 9)));
    }

    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
