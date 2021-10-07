package cn.ms22.chapter1;

import cn.ms22.utils.CommonUtil;

public class ReversePair {
    public static void main(String[] args) {
//        int[] arr = CommonUtil.arrGenerator(10);
        int[] arr = new int[]{3,9,1,4,5};
        CommonUtil.print(arr);
        slip(arr);
        CommonUtil.print(arr,"end:");
    }

    private static void slip(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int idxL = L;
        int idxR = mid + 1;
        int idxh = 0;
        int[] help = new int[R - L + 1];
        while (idxL <= mid && idxR <= R) {
            if (arr[idxL] > arr[idxR]) {
                for (int idx = idxR; idx <= R; idx++) {
                    System.out.println("{" + arr[idxL] + "," + arr[idx] + "}");
                }
            }
            help[idxh++] = arr[idxL] > arr[idxR] ? arr[idxL++] : arr[idxR++];
        }
        while (idxL <= mid) {
            help[idxh++] = arr[idxL++];
        }
        while (idxR <= R) {
            help[idxh++] = arr[idxR++];
        }
        for (int val : help) {
            arr[L++] = val;
        }

    }
}
