package com.zy.stack;

import java.util.Stack;

/**
 * @author:
 * @Date: 2020-02-27 08:36
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class MinStack {

    private Stack<Integer> data;

    private Stack<Integer> aider;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.data = new Stack<>();
        this.aider = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (aider.isEmpty() || aider.peek() > x) {
            aider.add(x);
            return;
        }
        aider.push(aider.peek());
    }

    public void pop() {
        if (!data.isEmpty()) {
            data.pop();
            aider.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("data is empty ! can't top");
    }

    public int getMin() {
        if (!aider.isEmpty()) {
            return aider.peek();
        }
        throw new RuntimeException("aider is empty! can't get");
    }
}
