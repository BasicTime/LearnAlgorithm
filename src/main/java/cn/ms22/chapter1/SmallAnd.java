package cn.ms22.chapter1;

import cn.ms22.utils.CommonUtil;

public class SmallAnd {
    public static void main(String[] args) {
//        int arr[] = CommonUtil.arrGenerator(5);
        int arr[] = new int[]{1, 3, 4, 2, 5};//16
        SmallAnd smallAnd = new SmallAnd();

        CommonUtil.print(arr);
        System.out.println("小和：" + smallAnd.slip(arr));
        CommonUtil.print(arr, "end：");

    }

    private int slip(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return smallAdd(arr, 0, arr.length - 1);
    }

    private int smallAdd(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return smallAdd(arr, L, mid) + smallAdd(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    private int merge(int[] arr, int L, int mid, int R) {
        int sumAdd = 0;
        int[] help = new int[R - L + 1];
        int idxh = 0;
        int idxl = L;
        int idxr = mid + 1;
        while (idxl <= mid && idxr <= R) {
            //1.粗暴方法
            /*if (arr[idxl] < arr[idxr]) {
                help[idxh++] = arr[idxl];
                sumAdd += (R - idxr + 1) * arr[idxl];
                idxl++;
            } else {
                help[idxh++] = arr[idxr];
                idxr++;
            }*/
            //2.优雅方法
            sumAdd += arr[idxl] < arr[idxr] ? arr[idxl] * (R - idxr + 1) : 0;
            help[idxh++] = arr[idxl] < arr[idxr] ? arr[idxl++] : arr[idxr++];
        }
        while (idxl <= mid) {
            help[idxh++] = arr[idxl++];
        }
        while (idxr <= R) {
            help[idxh++] = arr[idxr++];
        }

        for (int value : help) {
            arr[L++] = value;
        }
        return sumAdd;
    }
}
