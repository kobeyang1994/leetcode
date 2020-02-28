package com.zy.hash;

import java.util.*;

/**
 * @author:
 * @Date: 2020-02-23 21:50
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagramsCounter(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List<String>> ans = new HashMap<>(16);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }

}
