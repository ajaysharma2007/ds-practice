package com.ajay.educative.arrays;

public class MergeArrays {
    public static void main(String[] args) {
        int[] mergedArr = mergeArrays(new int[] { 1, 6, 9, 18 }, new int[] { 2, 5, 7, 19 });
        for (int var : mergedArr) {
            System.out.println(var);
        }
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {

        int arr1Size = arr1.length;
        int arr2Size = arr2.length;

        int finalArrSize = arr1Size + arr2Size;

        int[] finalArr = new int[finalArrSize];

        int i = 0, j = 0, k = 0;
        while (i < arr1Size && j < arr2Size) {
            if (arr1[i] <= arr2[j]) {
                finalArr[k++] = arr1[i++];
            } else {
                finalArr[k++] = arr2[j++];
            }
        }

        while (i < arr1Size) {
            finalArr[k++] = arr1[i++];
        }

        while (j < arr2Size) {
            finalArr[k++] = arr2[j++];
        }

        return finalArr;
    }
}