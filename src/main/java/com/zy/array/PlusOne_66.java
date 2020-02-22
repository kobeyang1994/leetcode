package com.zy.array;

/**
 * @author:
 * @Date: 2020-02-22 08:08
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class PlusOne_66 {
    /**
     * 从后向前遍历 ，因为地位在后边 高位在前边
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] newResult = new int[digits.length + 1];
        newResult[0] = 1;
        return newResult;
    }
}
