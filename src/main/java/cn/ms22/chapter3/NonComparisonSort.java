package cn.ms22.chapter3;

import cn.ms22.BaseSort;
import cn.ms22.utils.CommonUtil;

/**
 * 目前只能处理正整数范围内的数
 * 基于非比较性质的排序
 * 要求是，排序数组arr，arr[]是存放 0-60的N长度的数组，时间复杂度O(N),额外空间复杂的O(N)
 */
public class NonComparisonSort extends BaseSort {
    public static void main(String[] args) {
//        int[] arr = CommonUtil.arrGenerator(10, 0, 30);
//        new NonComparisonSort().print(arr).sort(arr).print(arr, "end");
        new NonComparisonSort().compare(10, 0, 10, CommonUtil.Order.ASC);
    }

    @Override
    public BaseSort sort(int[] arr) {

        int[] tmp = new int[maxValue(arr) + 1];
        for (int curV : arr) {
            tmp[curV]++;
        }

        int arrIdx = 0;
        int sum = 0;
        for (int cur = 0; cur < tmp.length; cur++) {
            int value = tmp[cur];
            sum += value;
            while (arrIdx < sum) {
                arr[arrIdx] = cur;
                arrIdx++;
            }
        }
        return this;
    }

    private int maxValue(int[] arr) {
        if (arr == null) {
            throw new NullPointerException("数组为空");
        }
        if (arr.length < 2) {
            return arr[0];
        }
        return maxValue(arr, 0, arr.length - 1);
    }

    private int maxValue(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMaxValue = maxValue(arr, L, mid);
        int rightMaxValue = maxValue(arr, mid + 1, R);
        return Math.max(leftMaxValue, rightMaxValue);
    }
}
