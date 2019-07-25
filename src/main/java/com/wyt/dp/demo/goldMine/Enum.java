package com.wyt.dp.demo.goldMine;

/**
 * 枚举法
 * <p>
 * 时间复杂度：每一座金矿都有挖与不挖两种选择，如果有N座金矿，排列组合起来就有2^N种选择，O(2^N)
 * <p>
 * Created by wangyitao on 2019/7/24.
 */
public class Enum {

    public static void main(String[] args) {
        int w = 10;
        int[] p = {5, 5, 3, 4, 3};
        int[] g = {400, 500, 200, 300, 350};
        System.out.println("最优受益:" + getBestGoldMining(w, p, g));
    }

    /**
     * 获得金矿最优受益
     *
     * @param: w   工人数量
     * @param: n   可选金矿数量
     * @param: p[] 金矿开采所需的工人数量
     * @param: g[] 金矿储量
     */
    private static int getBestGoldMining(int w, int[] p, int[] g) {
        //1、创建二维数组
        int[][] resultTable = new int[g.length + 1][w + 1];
        //填充表格
        //代码中有两层循环第一个 for 循环每座金矿的储量
        //按照一行一行循环，对于二维数组
        for (int i = 1; i < g.length + 1; i++) {
            //第二个 for 循环工人数
            for (int j = 1; j < w + 1; j++) {
                //当前这座金矿不满足开采人数时，那么把当前值的前一个位置的值赋给当前值
                if (j < p[i - 1]) {
                    resultTable[i][j] = resultTable[i - 1][j];
                }
                //满足开采人数
                else {
                    //resultTable[i-1][j]:当前位置的上头顶的那个元素
                    //resultTable[i-1][j-p[i-1]]+g[i-1]:这一行是找到上一步的局部最优解
                    resultTable[i][j] = Math.max(resultTable[i - 1][j],
                            resultTable[i - 1][j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        return resultTable[g.length][w];
    }

}
