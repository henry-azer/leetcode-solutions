package org.henry;

public class Main {

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'n', 'r', 'y'};
        reverseString(chars);
        System.out.println(chars);
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
