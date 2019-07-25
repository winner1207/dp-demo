package com.wyt.dp.demo.lcs;

import java.util.TreeSet;

/**
 * Created by wangyitao on 2019/7/25.
 */
public class Dp2 {

    private static String X;
    private static String Y;
    private static int[][] table;  // 动态规划表
    private static TreeSet<String> set = new TreeSet<String>();

    /**
     * 功能：main方法 —— 程序的入口
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        X = "sjAS2%1dk*k1d19sdjhh1288[shasSDJ82nhnm123mns[jasdjh123890dskajzn27hjhdjha;zmxn=camn21kjdxmaa02nbgbbnnHF87DLndf8DFHDJdhf";
        Y = "DJ913jkdDHJSHA217hgganmzcbbf/41@!#djas-123nfkjlHDFJH23h1nsd'JDFJSDshjhd2181]ksaznbvcgvYDSA(*u(hdf1y23kjdsNBU[P2jidfsuaio1s";
        printLCS();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 功能：求两个数中的较大者
     */
    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * 功能：构造表，并返回X和Y的LCS的长度
     */
    private static int lcs(int m, int n) {
        table = new int[m + 1][n + 1]; // 表的大小为(m+1)*(n+1)
        for (int i = 0; i < m + 1; ++i) {
            for (int j = 0; j < n + 1; ++j) {
                // 第一行和第一列置0
                if (i == 0 || j == 0)
                    table[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    table[i][j] = table[i - 1][j - 1] + 1;
                else
                    table[i][j] = max(table[i - 1][j], table[i][j - 1]);
            }
        }
        return table[m][n];
    }

    /**
     * 功能：回溯，求出所有的最长公共子序列，并放入set中
     */
    private static void traceBack(int i, int j, String lcs_str) {
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs_str += X.charAt(i - 1);
                --i;
                --j;
            } else {
                if (table[i - 1][j] > table[i][j - 1])
                    --i;
                else if (table[i - 1][j] < table[i][j - 1])
                    --j;
                else {  // 相等的情况
                    traceBack(i - 1, j, lcs_str);
                    traceBack(i, j - 1, lcs_str);
                    return;
                }
            }
        }
        set.add(reverse(lcs_str));
    }

    /**
     * 功能：字符串逆序
     */
    private static String reverse(String str) {
        StringBuffer strBuf = new StringBuffer(str).reverse();
        return strBuf.toString();
    }

    /**
     * 功能：外部接口 —— 打印输出
     */
    public static void printLCS() {
        int m = X.length();
        int n = Y.length();
        int length = lcs(m, n);
        String str = "";
        traceBack(m, n, str);

        System.out.println("The length of LCS is: " + length);
        for (String s : set) {
            System.out.println(s);
        }
    }

}
