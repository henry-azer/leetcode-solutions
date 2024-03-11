package org.henry;

public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        int[] nums = {555, 90, 482, 1771, 3990};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int digits = 1;
            while (num > 9) {
                num /= 10;
                digits += 1;
            }
            if (digits % 2 == 0) count += 1;
        }
        return count;
    }
}
