package com.zy.hash;

import java.util.Arrays;

/**
 * @author:
 * @Date: 2020-02-24 16:55
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class ValidNaagram_242 {
    public boolean isAnagramCounter(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < t.length(); i++) {
            if (counter[t.charAt(i) - 'a'] != 0) {
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return (String.valueOf(sChars)).equalsIgnoreCase(String.valueOf(tChars));
    }
}
