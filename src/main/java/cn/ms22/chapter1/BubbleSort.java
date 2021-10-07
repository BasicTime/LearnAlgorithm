package cn.ms22.chapter1;

import cn.ms22.utils.CommonUtil;

import java.util.Collections;

public class BubbleSort {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] arr = CommonUtil.arrGenerator(10);
            int[] arrClone = arr.clone();
//            sort(arr);
            sortOther(arr);
            CommonUtil.comparator(arrClone, arr);
        }
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1, cur = 0; j < arr.length - i; j++, cur++) {
                if (arr[cur] > arr[j]) {
                    CommonUtil.swap(arr, cur, j);
                }
            }
        }
    }

    private static void sortOther(int[] arr) {
        for (int end = arr.length - 1; end >= 0; end--) {
            for (int cur = 0; cur < end; cur++) {
                if (arr[cur] > arr[cur + 1]) {
                    CommonUtil.swap(arr, cur, cur + 1);
                }
            }
        }
    }


}
