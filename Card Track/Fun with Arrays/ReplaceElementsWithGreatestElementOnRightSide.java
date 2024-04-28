package org.henry;

import java.util.Arrays;
import java.util.LinkedList;

public class ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {
        int[] nums = {17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(replaceElements(nums)));
        int[] nums2 = {17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(replaceElements2(nums2)));
    }

    public static int[] replaceElements(int[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxIndex <= i) {
                maxIndex = i + 1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > arr[maxIndex]) maxIndex = j;
                }
            }
            arr[i] = maxIndex < arr.length ? arr[maxIndex] : -1;
        }
        return arr;
    }

    public static int[] replaceElements2(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }
        return arr;
    }
}
