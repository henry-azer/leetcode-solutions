package org.henry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{1, 2, 2, 3, 5, 6, 6, 6, 7, 7, 8};
        int k1 = removeDuplicates1(nums);
        System.out.println(k1 + ", nums = " + Arrays.toString(nums));

        nums = new int[]{1, 2, 2, 3, 5, 6, 6, 6, 7, 7, 8};
        int k2 = removeDuplicates2(nums);
        System.out.println(k2 + ", nums = " + Arrays.toString(nums));
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) uniqueNums.add(num);

        int index = 0;
        for (int uniqueNum : uniqueNums) {
            nums[index] = uniqueNum;
            index++;
        }
        return uniqueNums.size();
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;

        int sortedIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[sortedIndex]) {
                sortedIndex++;
                nums[sortedIndex] = nums[i];
            }
        }

        return sortedIndex + 1;
    }
}
