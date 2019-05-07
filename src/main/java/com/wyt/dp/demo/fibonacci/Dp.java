package com.wyt.dp.demo.fibonacci;

/**
 * 动态规划
 * <p>
 * 时间复杂度：一次循环，o(n)
 * <p>
 * 空间复杂度：o(1)
 * <p>
 * Created by wangyitao on 2019/5/6.
 */
public class Dp {

    public static void main(String[] args) {
        System.out.println(fn(10));
    }

    public static int fn(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
