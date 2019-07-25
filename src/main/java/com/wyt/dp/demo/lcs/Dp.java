package com.wyt.dp.demo.lcs;

/**
 * Created by wangyitao on 2019/7/25.
 */
public class Dp {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s1 = "sjAS2%1dk*k1d19sdjhh1288[shasSDJ82nhnm123mns[jasdjh123890dskajzn27hjhdjha;zmxn=camn21kjdxmaa02nbgbbnnHF87DLndf8DFHDJdhf";
        String s2 = "DJ913jkdDHJSHA217hgganmzcbbf/41@!#djas-123nfkjlHDFJH23h1nsd'JDFJSDshjhd2181]ksaznbvcgvYDSA(*u(hdf1y23kjdsNBU[P2jidfsuaio1s";
        System.out.println("lcs:" + findLcs(s1, s2));
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start));
    }

    public static String findLcs(String str1, String str2) {
        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();

        int length1 = ch1.length;
        int length2 = ch2.length;
        int max = 0;
        int sign = 0;
        int[] mat = new int[length1];

        for (int i = 0; i < length2; i++) {
            for (int j = length1 - 1; j >= 0; j--) {
                if (ch2[i] == ch1[j]) {
                    if (i == 0 || j == 0) {
                        mat[j] = 1;
                        if (max == 0) {
                            max = 1;
                            sign = j;
                        }
                    } else {
                        mat[j] = mat[j - 1] + 1;
                        if (mat[j] > max) {
                            max = mat[j];
                            sign = j;
                        }
                    }
                } else {
                    mat[j] = 0;
                }
            }
        }
        return new String(ch1, sign - max + 1, max);
    }

}
