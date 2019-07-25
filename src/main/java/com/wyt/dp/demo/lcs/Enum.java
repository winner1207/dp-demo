package com.wyt.dp.demo.lcs;

import java.util.ArrayList;
import java.util.List;

/**
 * 枚举法：时间复杂度：o(m*n^2)
 * Created by wangyitao on 2019/7/25.
 */
public class Enum {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s1 = "sjAS2%1dk*k1d19sdjhh1288[shasSDJ82nhnm123mns[jasdjh123890dskajzn27hjhdjha;zmxn=camn21kjdxmaa02nbgbbnnHF87DLndf8DFHDJdhf";
        String s2 = "DJ913jkdDHJSHA217hgganmzcbbf/41@!#djas-123nfkjlHDFJH23h1nsd'JDFJSDshjhd2181]ksaznbvcgvYDSA(*u(hdf1y23kjdsNBU[P2jidfsuaio1s";
        List<String> subStrings = new ArrayList<>();
        System.out.println("lcs:" + findLcs(s1, s2, subStrings));
        System.out.println("subStrings size:" + subStrings.size());
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start));
    }

    public static String findLcs(String s1, String s2, List<String> subStrings) {
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String tmp = String.valueOf(chars[i]);
            subStrings.add(tmp);
            for (int j = i + 1; j < chars.length; j++) {
                tmp += chars[j];
                subStrings.add(tmp);
            }
        }
        int max = 0;
        String lcs = null;
        for (int i = 0; i < subStrings.size(); i++) {
            String str = subStrings.get(i);
            if (s2.contains(str)) {
                if (max == 0) {
                    lcs = str;
                    max = str.length();
                } else {
                    if (str.length() > max) {
                        lcs = str;
                        max = str.length();
                    }
                }
            }
        }
        return lcs;
    }
}
