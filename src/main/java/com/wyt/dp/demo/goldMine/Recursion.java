package com.wyt.dp.demo.goldMine;

/**
 * 可以分为两个状态1、第五金矿不挖、前四个金矿中挖两个，2第五个金矿选择挖，和前四个金矿选择挖一个 同时人数剩余7人。
 * 这个两个结构都是这个大问题的最优子结构 但是这个最优子结构和这个金矿选择有什么关于呢？没错 就是两者选其中最大的一个。
 * <p>
 * 我们将金矿数设置为N,工人数为W,金矿的数量设置为数组G[],金矿的用工量设置为数组p[]。则得到结论：
 * <p>
 * F（5,10）=MAX(F(4,10),F(4,10-P[4])+G[4])
 * <p>
 * ok 现在我们 找到了最优子结构和和状态转移方程式，但是程序的边界是什么呢？
 * 这个很简单边界就是只剩下一个金矿可以选择我们必须挖这个唯一的金矿，但是这个时候我们需要满足一个 条件就是剩余的总人数大于挖改矿需要的人数。
 * Created by wangyitao on 2019/7/24.
 */
public class Recursion {

    public static void main(String[] args) throws Exception {
        int w = 10;
        int[] p = {5, 5, 3, 4, 3};
        int[] g = {400, 500, 200, 300, 350};
        System.out.println("最优受益:" + getBestGoldMining(w, g.length, p, g));
    }

    /**
     * 获得金矿最优受益
     *
     * @param: w   工人数量
     * @param: n   可选金矿数量
     * @param: p[] 金矿开采所需的工人数量
     * @param: g[] 金矿储量
     */
    private static int getBestGoldMining(int w, int n, int[] p, int[] g) {
        //当可选的金矿为0 或者 工人数为0
        if (w == 0 || n == 0) {
            return 0;
        }
        //当工人的数量不足以满足当前这座金矿需要的工人时
        if (w < p[n - 1]) {
            return getBestGoldMining(w, n - 1, p, g);
        }
        return Math.max(getBestGoldMining(w, n - 1, p, g),
                getBestGoldMining(w - p[n - 1], n - 1, p, g) + g[n - 1]);
    }
}
