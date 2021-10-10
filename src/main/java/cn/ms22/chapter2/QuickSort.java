package cn.ms22.chapter2;

import cn.ms22.BaseSort;
import cn.ms22.utils.CommonUtil;

/**
 * 随机快排
 */
public class QuickSort extends BaseSort {
    public static void main(String[] args) {
        int[] arr = CommonUtil.arrGenerator(10,-10,10);
//        new QuickSort().print(arr).sort(arr).print(arr,"end");
        new QuickSort().compare(100000, CommonUtil.Order.ASC);
    }


    private static void quickSort(int[] arr, int L, int R, int num) {
        if (L == R) {
            return;
        }
        int[] boundaries = partition(arr, L, R, num);

        if (L < boundaries[0]) {
            //在需要排序的区间内随机找一个数来比较
            int randomIdx = L + ((int) Math.random() * (boundaries[0] - L + 1));
            quickSort(arr, L, boundaries[0], arr[randomIdx]);
        }
        if (R > boundaries[1]) {
            //在需要排序的区间内随机找一个数来比较
            int randomIdx = L + ((int) Math.random() * (R - boundaries[1] + 1));
            quickSort(arr, boundaries[1], R, arr[randomIdx]);
        }
    }

    private static int[] partition(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        //如果less和more发生了改变，会不会改变这里的值呢？
        // 属于值传递，不会改变
//        int[] boundaries = new int[]{less, more};
        int cur = L;
        //界定边界
        while (cur < more) {
            if (arr[cur] < num) {
                CommonUtil.swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                CommonUtil.swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        return new int[]{less, more};
    }

    @Override
    public BaseSort sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return this;
        }
        quickSort(arr, 0, arr.length - 1, arr[arr.length - 1]);
        return this;
    }
}
