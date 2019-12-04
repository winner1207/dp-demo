package com.wyt.dp.demo.matrix;

/**
 * master
 * Created by wangyitao on 2019/12/4.
 */
public class Enum2 {

    public static void main(String[] args) {
        int[][] arr1 = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        int sum = countSquares(arr1);
        System.out.println(sum);
    }

    public static int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;
        for (int x = 0; x < n; x++) {      // 枚举左上角的 x
            for (int y = 0; y < m; y++) {  // 枚举左上角的 y
                for (int size = Math.min(n - x, m - y); size >= 1; size--) { // 枚举 [1, min(n-x, m-y)]这么多的方阵(size表示方阵大小)
                    if (check(matrix, x, y, size)) {  //检查这个方阵是否全为1
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private static boolean check(int[][] matrix, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (matrix[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
