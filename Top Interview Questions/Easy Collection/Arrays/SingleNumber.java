package org.henry;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 3, 2, 3, 6, 6};
        System.out.println(singleNumber1(nums1));
        System.out.println(singleNumber2(nums1));
        System.out.println(singleNumber3(nums1));

        int[] nums2 = {4,1,2,1,2};
        System.out.println(singleNumber1(nums2));
        System.out.println(singleNumber2(nums2));
        System.out.println(singleNumber3(nums2));
    }

    public static int singleNumber1(int[] nums) {
        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }

    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> fails = new HashSet<>();
        for (int num : nums) if (!set.add(num)) fails.add(num);
        for (int num : set) if (!fails.contains(num)) return num;
        return 0;
    }

    public static int singleNumber3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int key : map.keySet()) if (map.get(key) == 1) return key;
        return 0;
    }
}
