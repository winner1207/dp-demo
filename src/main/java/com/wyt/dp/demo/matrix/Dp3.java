package com.wyt.dp.demo.matrix;

/**
 * Created by wangyitao on 2019/12/3.
 */
public class Dp3 {
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
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 1) {
                    continue;
                }
                result++;
                if (j == 0) {
                    matrix[i][j] = 1;
                    continue;
                }
                matrix[i][j] = matrix[i][j - 1] + 1;
                if (i == 0) {
                    continue;
                }
                int maxlen = matrix[i][j];
                int minlen = maxlen;
                int row = i - 1;
                int curlen = 2;
                while (row >= 0 && curlen <= maxlen) {
                    minlen = Math.min(matrix[row][j], minlen);
                    if (minlen < curlen) {
                        break;
                    }
                    result++;
                    row--;
                    curlen++;
                }
            }
        }
        return result;
    }
}
