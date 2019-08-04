package com.ajay.educative.arrays;

import java.util.HashSet;
import java.util.Set;

import com.ajay.educative.sort.QuickSort;

public class FindSumNum {

    public static void main(String[] args) {
        int[] pairArr = findSum(new int[] { 1, 21, 3, 14, 5, 60, 7, 6 }, 27);
        for (int num : pairArr) {
            System.out.println(num);
        }
    }

    // TIme Complexity : n^2
    public static int[] findSum(int[] arr, int n) {
        Boolean foundPairs = Boolean.valueOf(false);
        int[] result = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            int num2 = n - arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == num2) {
                    result[0] = arr[i];
                    result[1] = num2;
                    foundPairs = true;
                    break;
                }
            }
            if (foundPairs) {
                break;
            }
        }
        return result;
    }

    // Time Complexity : nlogn
    public static int[] findSumSortedArr(int[] arr, int sum) {
        int[] result = new int[2];

        QuickSort.sort(arr);

        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] < sum) {
                i++;
            } else if (arr[i] + arr[j] > sum) {
                j--;
            } else {
                result[0] = arr[i];
                result[1] = arr[j];
            }
        }

        return arr;
    }

    // Time Complexity : n
    public static int[] findSumHashSet(int[] arr, int n) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<Integer>();
        for (int i : arr) {
            if (set.contains(n - i)) {
                result[0] = i;
                result[1] = n - i;
                break;
            }
            set.add(i);
        }
        return result;
    }
}
