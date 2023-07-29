package org.henry;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram2(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        int[] charsCount = new int[26];
        for (char ch : s.toCharArray()) charsCount[ch % 26]++;
        for (char ch : t.toCharArray()) charsCount[ch % 26]--;
        for (int charCount : charsCount) if (charCount != 0) return false;
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : s.toCharArray()) sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        for (char ch : t.toCharArray()) tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        return sMap.equals(tMap);
    }
}
