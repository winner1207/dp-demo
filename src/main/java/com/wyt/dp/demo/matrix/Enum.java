package com.wyt.dp.demo.matrix;

/**
 * Created by wangyitao on 2019/12/3.
 */
public class Enum {

    public static void main(String[] args) {
        int[][] arr1 = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        int sum = 0;
        int n = 0;//子矩形的边长
        for (int i = 0; i < arr1.length; i++) {
            int[] arr2 = arr1[i];
            if (n == 0) {
                n = arr1.length > arr2.length ? arr2.length : arr1.length;
            }
            for (int j = 0; j < arr2.length; j++) {
                int a = arr2[j];
                if (a == 0) {
                    continue;
                } else {
                    sum++;
                }
                for (int k = 2; k <= n; k++) {
                    int[][] arr3 = getArr(arr1, i, j, k);
                    if (isSquare(arr3)) {
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static int[][] getArr(int[][] arr1, int x, int y, int n) {
        if (x + n > arr1.length) {
            return null;
        }
        int h = y;
        int[][] rs = new int[n][n];
        for (int i = 0; i < arr1.length; i++) {
            if (i > arr1.length - 1 || (i + 1) > n) {
                break;
            }
            int[] arr2 = arr1[i];
            if (y + n > arr2.length) {
                return null;
            }
            for (int j = 0; j < arr2.length; j++) {
                if (y > arr2.length - 1 || (j + 1) > n) {
                    break;
                }
                rs[i][j] = arr1[x][y];
                y++;
            }
            x++;
            y = h;
        }
        return rs;
    }

    public static boolean isSquare(int[][] arr1) {
        if (arr1 == null || arr1.length == 0) {
            return false;
        }
        boolean rs = true;
        for (int i = 0; i < arr1.length; i++) {
            int[] arr2 = arr1[i];
            for (int j = 0; j < arr2.length; j++) {
                int a = arr2[j];
                if (a != 1) {
                    rs = false;
                    break;
                }
            }
            if (arr1.length != arr2.length) {
                rs = false;
                break;
            }
        }
        return rs;
    }
}
