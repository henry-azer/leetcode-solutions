package org.henry;

public class Main {

    public static void main(String[] args) {
        String value = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(value));
        System.out.println(isPalindrome2(value));
        System.out.println(isPalindrome3(value));
    }

    //    3 ms, 42.2 MB
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //    25 ms, 44.2 MB
    public static boolean isPalindrome2(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    //    28 ms, 43,8 MB
    public static boolean isPalindrome3(String s) {
        char[] chars = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
