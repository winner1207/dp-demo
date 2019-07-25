package com.wyt.dp.demo.fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归+备忘录算法
 * <p>
 * 时间复杂度：fn(1)到fn(n)一共有n次输入，o(n)
 * <p>
 * 空间复杂度：o(n)
 * <p>
 * Created by wangyitao on 2019/5/6.
 */
public class RecursionWithMemo {

    static Map<Integer, Integer> map = new HashMap<>();

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
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = fn(n - 1) + fn(n - 2);
            map.put(n, value);
            return value;
        }
    }


}
