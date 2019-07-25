package com.wyt.dp.demo.lcs;

/**
 * Created by wangyitao on 2019/7/25.
 */
public class Enum2 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s1 = "sjAS2%1dk*k1d19sdjhh1288[shasSDJ82nhnm123mns[jasdjh123890dskajzn27hjhdjha;zmxn=camn21kjdxmaa02nbgbbnnHF87DLndf8DFHDJdhf";
        String s2 = "DJ913jkdDHJSHA217hgganmzcbbf/41@!#djas-123nfkjlHDFJH23h1nsd'JDFJSDshjhd2181]ksaznbvcgvYDSA(*u(hdf1y23kjdsNBU[P2jidfsuaio1s";
        System.out.println("lcs:" + findLcs(s1, s2));
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start));
    }

    public static String findLcs(String s1, String s2) {
        char[] chars = s1.toCharArray();
        int max = 0;
        String maxStr = null;
        for (int i = 0; i < chars.length; i++) {
            String tmp = String.valueOf(chars[i]);
            if (!s2.contains(tmp)) {
                continue;
            } else {
                if (tmp.length() > max) {
                    max = tmp.length();
                    maxStr = tmp;
                }
            }
            for (int j = i + 1; j < chars.length; j++) {
                tmp += chars[j];
                if (!s2.contains(tmp)) {
                    continue;
                } else {
                    if (tmp.length() > max) {
                        max = tmp.length();
                        maxStr = tmp;
                    }
                }
            }
        }
        return maxStr;
    }
}
