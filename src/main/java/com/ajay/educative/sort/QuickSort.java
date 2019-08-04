package com.ajay.educative.sort;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        sort(arr);
        printArr(arr);

    }

    public static void sort(int[] arr) {
        
        // This helps in achieving the NlogN. Worst case is when array is already sorted.
        QuickSort.shuffleArray(arr);
        
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int index = partition(arr, low, high);
        quickSort(arr, low, index - 1);
        quickSort(arr, index + 1, high);
    }

    // Choose 1st element as pivot.
    // Find the element greater than pivot form LHS
    // Find an element lesser than pivot from RHS
    // Swap and continue.
    // Swap the jth index with the pivot and return.

    private static int partition(int[] arr, int low, int high) {
        int i = low + 1;
        int j = high;

        while (i <= j) {
            while (arr[i] < arr[low]) {
                if (i == high) {
                    // This increment is required to prevent infinite loop in case of reverse sorted
                    // array.
                    // If not present outermost loop will not exit in the above condition.
                    i++;

                    break;
                }
                i++;
            }
            while (arr[j] > arr[low]) {
                j--;
            }

            // This is required in order to prevent index out of bound exception in case of
            // the reversely sorted array.
            // Since we are incrementing i in that case, here swap will cause index out of
            // bounds.
            if (i < j)
                swapIndices(i, j, arr);
        }

        swapIndices(low, j, arr);
        return j;
    }

    private static void swapIndices(int index1, int index2, int[] arr) {
        if (index1 == index2) {
            return;
        }
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
    }

    private static void shuffleArray(int[] arr) {
        int index, temp;
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}