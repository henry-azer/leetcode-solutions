package org.henry;

import java.util.Arrays;

public class ValidMountainArray {

    public static void main(String[] args) {
        int[] nums = {0, 1, 5, 14, 11, 2, 1};
        System.out.println(validMountainArray(nums));
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        int i = 0;
        while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == arr.length - 1) return false;
        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == arr.length - 1;
    }
}
