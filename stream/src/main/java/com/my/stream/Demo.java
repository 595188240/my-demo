package com.my.stream;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ffdeng2
 */
public class Demo {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        Set<String> set = new HashSet<>();
        String last = null;
        for (int i = 0; i < 1000000; i++) {
            last = create(last);
            set.add(last);
        }
        System.out.println(last);
        System.out.println(set.size());
        System.out.println(System.currentTimeMillis() - begin + "ms");
    }

    private static Character zero = '0';
    private static Character nine = '9';
    private static Character a = 'a';
    private static Character z = 'z';
    private static String begin = "a000";

    private static String create(String last) {
        if (last == null || "".equals(last)) {
            return begin;
        }
        char[] chars = last.toCharArray();
        int jin = 1;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] == z) {
                chars[i] = zero;
                continue;
            } else if (chars[i] == nine) {
                chars[i] = a;
            } else {
                int c = chars[i] - zero;
                if (c < 10) {
                    chars[i] = numAdd(chars[i], jin);
                }
                if (c > 10) {
                    chars[i] = latterAdd(chars[i], jin);
                }
            }
            jin = 0;
            break;
        }
        if (jin == 1) {
            if (chars[0] == z) {
                //throw
            }
            chars[0] = latterAdd(chars[0], jin);
        }
        return new String(chars);
    }

    private static char numAdd(char c, int add) {
        return add(c, add, zero);
    }

    private static char latterAdd(char c, int add) {
        return add(c, add, a);
    }

    private static char add(char c, int add, char type) {
        return (char) (c - type + add + type);
    }
}
