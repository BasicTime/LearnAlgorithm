package cn.ms22.chapter2;

import cn.ms22.utils.CommonUtil;

public class DutchNationalFlag {
    public static void main(String[] args) {
//        int[] arr = CommonUtil.arrGenerator(10);
//        int[] arr = new int[]{5,4,3,2,7,6,1,9,10,5,8};
        int[] arr = new int[]{9, 8, 7, 6, 4, 3, 2, 10, 1};

        int num = 5;
        CommonUtil.print(arr);
        dutchNationalFlag(arr, num);
        CommonUtil.print(arr);
    }

    private static void dutchNationalFlag(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int boundaryL = L - 1;
        int boundaryR = R + 1;
        int cur = L;
        while (cur < boundaryR) {
            if (arr[cur] < num) {
                swap(arr, ++boundaryL, cur);
                cur++;
            } else if (arr[cur] == num) {
                cur++;
            } else if (arr[cur] > num) {
                swap(arr, --boundaryR, cur);
            }
        }
    }

    private static void swap(int[] arr, int l, int r) {
        CommonUtil.swap(arr, l, r);
    }
}
