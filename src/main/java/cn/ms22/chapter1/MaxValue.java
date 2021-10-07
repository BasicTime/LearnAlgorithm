package cn.ms22.chapter1;

import cn.ms22.utils.CommonUtil;

import java.util.Arrays;

/**
 * 使用递归的方法查找最大值
 * 递归，使用了分治策略的方式
 */
public class MaxValue {
    public static void main(String[] args) {
        int[] arr = CommonUtil.arrGenerator(10);
        CommonUtil.print(arr);
        System.out.println(maxValue(arr, 0, arr.length - 1));
        Arrays.sort(arr);
        CommonUtil.print(arr);
    }

    private static int maxValue(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }

        int mid = (L + R) / 2;
        int leftMax = maxValue(arr, 0, L);
        int rightMax = maxValue(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
