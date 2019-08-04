package com.ajay.educative.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class FirstUnique {
    public static void main(String[] args) {
        System.out.println(findFirstUnique(new int[] { 9, 2, 3, 2, 6, 6 }));
    }

    public static int findFirstUnique(int[] arr) {
        int result = -1;
        Map<Integer, Integer> valueCountMap = new HashMap<>();
        for (int num : arr) {
            if (valueCountMap.containsKey(num)) {
                Integer value = valueCountMap.get(num);
                valueCountMap.put(num, ++value);
            } else {
                valueCountMap.put(num, 1);
            }
        }

        Set<Entry<Integer, Integer>> entries = valueCountMap.entrySet();
        for (Entry<Integer, Integer> valueCountEntry : entries) {
            if (valueCountEntry.getValue() == 1) {
                result = valueCountEntry.getKey();
            }
        }
        return result;
    }
}