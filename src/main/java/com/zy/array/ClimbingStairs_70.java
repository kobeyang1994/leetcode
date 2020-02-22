package com.zy.array;

/**
 * @author:
 * @Date: 2020-02-21 09:54
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class ClimbingStairs_70 {

    public int climbStairsLoop(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int firstStep = 1;
        int secondStep = 2;

        int totalStep = 0;
        for (int i = 3; i <= n; i++) {
            totalStep = firstStep + secondStep;
            firstStep = secondStep;
            secondStep = totalStep;
        }

        return totalStep;
    }

    public int climbStairs(int n) {
        int[] memory = new int[n + 1];
        return climbStairsRecursion(n,memory);

    }

    private int climbStairsRecursion(int n,int[] memory) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if(memory[n] != 0) {
            return memory[n];
        }
        memory[n] = climbStairsRecursion(n - 1,memory) + climbStairsRecursion(n - 2,memory);
        return memory[n];
    }
}
