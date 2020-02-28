package com.zy.loop.iterative;

import org.junit.Test;

/**
 * @author:
 * @Date: 2020-02-26 10:22
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class IterativeMethod {

    @Test
    public void test() {
        System.out.println(getNumberOfWheat(64));
        System.out.println(getSquareRoot(11, 0.01, 10));
    }

    /**
     * 舍罕下棋
     *
     * @param grid
     * @return
     */
    private long getNumberOfWheat(int grid) {
        long numberOfWheat = 0;
        for (int i = 0; i < grid; i++) {
            numberOfWheat += Math.pow(2, i);
        }
        return numberOfWheat;
    }

    /**
     * @param n
     * @param deltaThreshold
     * @param maxTry
     * @return
     */
    private double getSquareRoot(int n, double deltaThreshold, int maxTry) {
        if (n <= 1) {
            return -1.0;
        }

        double min = 1.0;
        double max = (double) n;

        for (int i = 0; i < maxTry; i++) {
            double mid = (min + max) / 2;
            double square = mid * mid;
            double delta = Math.abs(square / n - 1);
            if (delta <= deltaThreshold) {
                return mid;
            }
            if (square > n) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return -2.0;
    }

}
