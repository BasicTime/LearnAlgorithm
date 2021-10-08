package cn.ms22.chapter2;

import cn.ms22.utils.CommonUtil;

public class Partition {
    public static void main(String[] args) {
//        int arr[] = CommonUtil.arrGenerator(10);
        int[] arr = new int[]{1, 9, 5, 3, 10, 7, 6, 5, 8, 1, 3, 5};
        int num = 5;
        CommonUtil.print(arr);
        partition(arr, num);
        CommonUtil.print(arr);
    }

    private static void partition(int[] arr, int num) {
        int boundary = -1;
        int L = 0;
        int R = arr.length - 1;
        int cur = L;
        while (cur <= R) {
            if (arr[cur] <= num) {
                swap(arr, ++boundary, cur);
            }
            cur++;
        }
    }

    private static void swap(int[] arr, int i, int cur) {
        CommonUtil.swap(arr, i, cur);
    }
}
