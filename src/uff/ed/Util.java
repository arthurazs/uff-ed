/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed;

/**
 *
 * @author Arthur Zopellaro
 */
public class Util {

    public static int mod(int number, int modulus) {
        int result = number % modulus;
        if (result < 0)
            result += modulus;
        return result;
    }
    
}
