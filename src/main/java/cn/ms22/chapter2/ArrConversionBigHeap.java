package cn.ms22.chapter2;

import cn.ms22.utils.CommonUtil;

public class ArrConversionBigHeap {
    public static void main(String[] args) {
//        int arr[] = new int[]{6, 3, 8, 1, 0, 4};
        int arr[] = new int[]{6, 3, 1, 1, 0, 4};
        CommonUtil.print(arr);
        conversion(arr);
        CommonUtil.print(arr);
    }

    /**
     * 时间复杂度N*logN
     *
     * @param arr
     */
    private static void conversion(int[] arr) {
        for (int cur = 0; cur < arr.length; cur++) {
//            findAndChange(arr, cur);
//            heapInsert(arr, cur);
            heapInsert1(arr, cur);
        }
    }

    private static void heapInsert(int[] arr, int cur) {
        for (int head = (cur - 1) / 2; cur > 0; cur = head, head = (cur - 1) / 2) {
            if (arr[cur] > arr[head]) {
                CommonUtil.swap(arr, cur, head);
            }
        }
    }

    private static void heapInsert1(int[] arr, int cur) {
        //这里的(cur-1)/2会防止下标越界，如(0-1)/2=0
        while (arr[cur] > arr[(cur - 1) / 2]) {
            CommonUtil.swap(arr, cur, (cur - 1) / 2);
            cur = (cur - 1) / 2;
        }

    }

    /**
     * 递归
     *
     * @param arr
     * @param cur
     */
    private static void findAndChange(int[] arr, int cur) {
        if (cur <= 0) {
            return;
        }
        int head = (cur - 1) / 2;
        if (arr[head] < arr[cur]) {
            CommonUtil.swap(arr, head, cur);
        }
        findAndChange(arr, head);
    }
}
