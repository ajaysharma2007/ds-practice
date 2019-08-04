package com.ajay.educative.arrays;

public class ProductOfAllElements {
    public static void main(String[] args) {
        // printArr(findProduct(new int[] { 1, 2, 3, 4 }));
        // printArr(findProduct(new int[] { 4, 2, 1, 5, 0 }));
        printArr(findProduct(new int[] { 0, 1, 2 }));
    }

    public static int[] findProduct(int arr[]) {
        int[] result = new int[arr.length];
        int product = 1;
        int zeroCount = 0;

        for (int num : arr) {
            if (num == 0 && zeroCount == 0) {
                zeroCount++;
            } else {
                product = product * num;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (zeroCount > 0 && num != 0) {
                result[i] = 0;
            } else {
                num = num == 0 ? 1 : num;
                result[i] = product / num;
            }
        }
        return result;
    }

    public static int[] findProductLeftRight(int[] arr) {
        int n = arr.length;
        int i, temp = 1;

        // Allocation of result array
        int result[] = new int[n];

        // Initializing the result array by 1
        for (int j = 0; j < n; j++) {
            result[j] = 1;
        }

        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++) {
            result[i] = temp;
            temp *= arr[i];
        }

        // Initializing temp to 1 for product on right side
        temp = 1;

        // Product of elements on right side excluding arr[i] */
        for (i = n - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }

        return result;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println();
    }

}