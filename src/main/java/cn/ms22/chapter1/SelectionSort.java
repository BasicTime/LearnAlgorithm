package cn.ms22.chapter1;

import cn.ms22.BaseSort;
import cn.ms22.utils.CommonUtil;

public class SelectionSort extends BaseSort {
    public static void main(String[] args) {
        new SelectionSort().compare(100, CommonUtil.Order.ASC);
    }

    public SelectionSort sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return this;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                CommonUtil.swap1(arr, min, i);
            }
        }
        return this;
    }
}
