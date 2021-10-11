package cn.ms22.chapter3;

import cn.ms22.utils.CommonUtil;

import java.util.Arrays;

public class MaxGap {
    public static void main(String[] args) {
//        int[] arr = CommonUtil.arrGenerator(10, -50, 50);
//        int[] arr = new int[]{12, 0, -15, -43, 42, 31, -50, 11, 27, 46};
        int[] arr = new int[]{1,5,5,5,5,5,5,6};
        CommonUtil.print(arr);
        Arrays.sort(arr);
        CommonUtil.print(arr);
        System.out.println(calculator(arr));

    }

    public static int calculator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int arrMax = Integer.MIN_VALUE;
        int arrMin = Integer.MAX_VALUE;
        //记录最大值最小值
        for (int value : arr) {
            arrMax = Math.max(arrMax, value);
            arrMin = Math.min(arrMin, value);
        }
        if(arrMax==arrMin){
            return 0;
        }
        boolean hasValues[] = new boolean[arr.length + 1];
        int[] maxValues = new int[arr.length + 1];
        int[] minValues = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            int bucket = (arr[i] - arrMin) * arr.length / (arrMax - arrMin);
            maxValues[bucket] = hasValues[bucket] ? maxValues[bucket] : Integer.MIN_VALUE;
            minValues[bucket] = hasValues[bucket] ? minValues[bucket] : Integer.MAX_VALUE;
            maxValues[bucket] = Math.max(arr[i], maxValues[bucket]);
            minValues[bucket] = Math.min(arr[i], minValues[bucket]);
            hasValues[bucket] = true;
            System.out.println("bucketIdx:" + bucket + " minV：" + minValues[bucket] + " MaxV:" + maxValues[bucket] + " arr[" + i + "]" + arr[i]);
        }

        int res = 0;
        int lastMax = maxValues[0];
        for (int i = 1; i < hasValues.length; i++) {
            if (hasValues[i]) {
                res = Math.max(minValues[i] - lastMax, res);
                lastMax = maxValues[i];
            }
        }
        return res;
    }
}
