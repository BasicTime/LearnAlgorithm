package cn.ms22.chapter1;

import cn.ms22.BaseSort;
import cn.ms22.utils.CommonUtil;

public class InsertionSort extends BaseSort {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.compare(100, CommonUtil.Order.ASC);
//        int[] arr = insertionSort.generator(10);
//        insertionSort.print(arr).sort(arr).print(arr, "pre");
    }

    public BaseSort sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1, cur = i; j >= 0 && cur >= 0; j--, cur--) {
                if (arr[j] < arr[cur]) {
                    CommonUtil.swap(arr, cur, j);
                } else {
                    break;
                }
            }
        }
        return this;
    }
}
