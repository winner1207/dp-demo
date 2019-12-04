package com.wyt.dp.demo.matrix;

/**
 * master
 * Created by wangyitao on 2019/12/4.
 */
public class Dp4 {

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
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + matrix[i][j];
                    res += dp[i + 1][j + 1];
                }
            }
        }
        return res;
    }
}
