package com.zy.math.binary;

import org.junit.Test;
import org.slf4j.Logger;

import java.math.BigInteger;

/**
 * 二进制操作
 * @author:
 * @Date: 2020-02-26 08:42
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class BinaryHandler {

    @Test
    public void tees() {
        System.out.println(binaryToDecimal("111011"));
        System.out.println(decimalToBinarySelf(59));
    }

    private int binaryToDecimal(String binary) {
        BigInteger bi = new BigInteger(binary, 2);
        return Integer.parseInt(bi.toString());
    }

    private String decimalToBinary(int decimal) {
        BigInteger bi = new BigInteger(String.valueOf(decimal));
        return bi.toString(8);
    }


    private String decimalToBinarySelf(int decimal) {
        StringBuffer result = new StringBuffer();
        while (decimal != 0){
            result.append(decimal & 1);
            decimal = (decimal >>> 1);
        }
        return result.reverse().toString();
    }
}
