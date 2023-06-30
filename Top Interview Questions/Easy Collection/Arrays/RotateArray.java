package org.henry;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int k1 = 5;
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8};

        rotate1(nums1, k1);
        System.out.println(Arrays.toString(nums1));

        int k2 = 5;
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8};
        rotate2(nums2, k2);
        System.out.println(Arrays.toString(nums2));
    }

    public static void rotate1(int[] nums, int k) {
        // handle redundant rotations
        k = k % nums.length;

        // rotate array using another array
        int[] rotated = new int[nums.length];
        for (int i = 0; i < nums.length; i++) rotated[(i + k) % nums.length] = nums[i];
        System.arraycopy(rotated, 0, nums, 0, rotated.length);
    }

    public static void rotate2(int[] nums, int k) {
        // handle redundant rotations
        k = k %  nums.length;

        // reverse entire array, then the first part, then the second part
        reverseArray1(nums, 0,  nums.length -1);
        reverseArray1(nums, 0, k - 1);
        reverseArray1(nums, k,  nums.length - 1);
    }

    public static void reverseArray1(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] =  arr[end];
            arr[end] =  temp;
            start++;
            end--;
        }
    }

    public static void reverseArray2(int[] arr, int start, int end) {
        while (start < end) {
            arr[start] ^= arr[end];
            arr[end] ^= arr[start];
            arr[start] ^= arr[end];
            start++;
            end--;
        }
    }
}
