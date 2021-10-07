package cn.ms22.chapter1;

import cn.ms22.BaseSort;
import cn.ms22.utils.CommonUtil;

public class MergeSort extends BaseSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        /*int[] arr = mergeSort.generator(10);
        mergeSort.print(arr).sort(arr).print(arr,"end:");*/
        mergeSort.compare(2, CommonUtil.Order.ASC);

    }

    @Override
    public BaseSort sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        mainSort(arr, 0, arr.length - 1);
        return this;
    }

    private void mainSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        //下标L 到 mid排序
        mainSort(arr, L, mid);
        //下标mid+1 到 R排序
        mainSort(arr, mid + 1, R);
        //合并小标L到下标R之间的值
        merge(arr, L, mid, R);
    }

    private void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int idxL = L;
        int idxR = mid + 1;
        int i = 0;
        while (idxL <= mid && idxR <= R) {
            help[i++] = arr[idxL] < arr[idxR] ? arr[idxL++] : arr[idxR++];
        }
        while (idxL <= mid) {
            help[i++] = arr[idxL++];
        }
        while (idxR <= R) {
            help[i++] = arr[idxR++];
        }
        for (int value : help) {
            arr[L++] = value;
        }
    }
}
