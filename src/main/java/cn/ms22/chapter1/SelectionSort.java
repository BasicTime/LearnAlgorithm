package cn.ms22.chapter1;

import cn.ms22.utils.CommonUtil;
import cn.ms22.utils.CommonUtil.Order;

import static cn.ms22.utils.CommonUtil.*;

public class SelectionSort {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            int arr[] = arrGenerator(10);
            int arrOriginal[] = arr.clone();
            print(arr,"prix:");
            sort(arr);
            print(arr,"end:");
            comparator(arrOriginal, arr, Order.ASC);
        }
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                CommonUtil.swap(arr, min, i);
            }
        }
    }
}
