package com.ajay.educative.arrays;

public class FindMinimum {

    public static void main(String[] args) {
        System.out.println(findMinimum(new int[]{9, 2, 3, 6}));
    }

    public static int findMinimum(int[] arr) {
        int minimum = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < minimum) {
                minimum = num;
            }
        }
        return minimum;
    }
}