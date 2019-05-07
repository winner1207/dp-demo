package com.wyt.dp.demo.fibonacci;

/**
 * 递归实现
 * <p>
 * 时间复杂度：二叉树求节点数，树高度为n，o(2^n)
 * <p>
 * Created by wangyitao on 2019/5/6.
 */
public class Loop {

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
        return fn(n - 1) + fn(n - 2);
    }
}
