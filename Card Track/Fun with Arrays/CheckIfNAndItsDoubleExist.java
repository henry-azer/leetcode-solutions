package org.henry;

import java.util.Arrays;

public class CheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        int[] nums = {7, 1, 14, 11};
        System.out.println(checkIfExist(nums));
        System.out.println(checkIfExist2(nums));
        System.out.println(checkIfExist3(nums));
    }

    public static boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] * 2) || (arr[i] % 2 == 0 && map.containsKey(arr[i] / 2))) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }

    public static boolean checkIfExist2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i] * 2, i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && map.get(arr[i]) != i) return true;
        }
        return false;
    }

    public static boolean checkIfExist3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == 2 * arr[j]) return true;
            }
        }
        return false;
    }
}
