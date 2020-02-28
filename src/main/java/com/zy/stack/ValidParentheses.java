package com.zy.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author:
 * @Date: 2020-02-27 08:17
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class ValidParentheses {

    private Map<Character, Character> mappings = new HashMap<>(16);

    public ValidParentheses() {
        this.mappings.put('}', '{');
        this.mappings.put(')', '(');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                Character mpRight = mappings.get(c);
                Character cc = stack.empty() ? '#' : stack.pop();
                if (!cc.equals(mpRight)) {
                    return false;
                }
                continue;
            }
            stack.push(c);
        }

        return stack.isEmpty();
    }
}
