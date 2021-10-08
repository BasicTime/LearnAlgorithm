package cn.ms22.chapter2;

import cn.ms22.BaseSort;
import cn.ms22.utils.CommonUtil;

public class ClassicQuickSort extends BaseSort {
    public static void main(String[] args) {
        new ClassicQuickSort().compare(10000000, CommonUtil.Order.ASC);
    }

    public BaseSort sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        basicSort(arr, 0, arr.length - 1, arr[arr.length - 1]);
        return this;
    }

    private static void basicSort(int[] arr, int L, int R, int num) {
        if (L == R) {
            return;
        }
        int[] boundaries = partition(arr, L, R, num);
        if (boundaries[0] > L) {
            basicSort(arr, L, boundaries[0] - 1, arr[boundaries[0] - 1]);
        }
        if (boundaries[0] < R) {
            basicSort(arr, boundaries[0] + 1, R, arr[R]);
        }

    }

    /**
     * 经典快排的方式\<=num放左边，\>num 放右边,找到的左边界如果不是左边最大的数就会出现栈溢出问题，所以需要把左边界的值
     * 置为左边最大的值
     *
     * @param arr
     * @param L
     * @param R
     * @param num
     * @return
     */
    private static int[] partition(int[] arr, int L, int R, int num) {
        int boundaryL = L - 1;
        int cur = L;
        int boundaryLMaxVarIdx = -1;//初始化最大值下标
        while (cur <= R) {
            if (arr[cur] <= num) {
                CommonUtil.swap(arr, ++boundaryL, cur++);
                if (boundaryLMaxVarIdx == -1) {
                    boundaryLMaxVarIdx = boundaryL;
                } else {
                    boundaryLMaxVarIdx = arr[boundaryLMaxVarIdx] > arr[boundaryL] ? boundaryLMaxVarIdx : boundaryL;
                }
            } else {
                cur++;
            }
        }
        if (boundaryLMaxVarIdx != -1) {
            CommonUtil.swap(arr, boundaryLMaxVarIdx, boundaryL);
        }
        return new int[]{boundaryL};
    }


}
