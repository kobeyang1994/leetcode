package com.zy.hash;

import java.util.*;

/**
 * @author:
 * @Date: 2020-02-27 17:00
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class Review {
    /**
     * 排序比较字符串是否想想等
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return String.valueOf(sChar).equals(String.valueOf(tChar));
    }

    /**
     * hash思想
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
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

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }
        Map<String,List<String>> mappings = new HashMap<>(16);
        for(String str: strs){
            char[] current = str.toCharArray();
            Arrays.sort(current);
            String key = String.valueOf(current);
            if(!mappings.containsKey(key)){
                mappings.put(key,new ArrayList<>());
            }
            mappings.get(key).add(str);
        }
        return new ArrayList<>(mappings.values());
    }
}