package com.pearz.algorithm.greedy;

import java.security.Key;
import java.util.HashMap;
import java.util.HashSet;

public class Greedy {
    public static void main(String[] args) {
        HashMap<String, HashSet> broadcast = new HashMap<>();//存放广播台及其覆盖地区

        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
//        hashSet1.add("广州");
//        hashSet1.add("深圳");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("北京");
        hashSet2.add("广州");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcast.put("K1", hashSet1);
        broadcast.put("K2", hashSet2);
        broadcast.put("K3", hashSet3);
        broadcast.put("K4", hashSet4);
        broadcast.put("K5", hashSet5);

        HashSet<String> allAreas = new HashSet<>();//存放所有地区
        for (HashSet hs : broadcast.values()) {
            allAreas.addAll(hs);
        }

        String maxKey;
        HashSet<String> tempHashSet;
        HashSet<String> maxKeyHashSet;
        while (allAreas.size() > 0) {
            maxKey = null;
            for (String key : broadcast.keySet()) {
                tempHashSet = broadcast.get(key);
                tempHashSet.retainAll(allAreas);

                maxKeyHashSet = broadcast.get(maxKey);
                if (maxKey != null) {
                    maxKeyHashSet.retainAll(allAreas);
                }
                if (tempHashSet.size() > 0 && (maxKey == null || tempHashSet.size() > maxKeyHashSet.size())) {
                    maxKey = key;
                }
            }
            allAreas.removeAll(broadcast.get(maxKey));
            System.out.println(maxKey);
        }
    }
}
