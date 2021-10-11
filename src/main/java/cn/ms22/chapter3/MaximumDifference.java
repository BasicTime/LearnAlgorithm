package cn.ms22.chapter3;

import cn.ms22.utils.CommonUtil;

import java.util.Arrays;

/**
 * 给定一个数组arr.length = N，求如果排序后，相邻两个数的最大差值，要求时间复杂度O(N),且要求不能用非基于比较的排序
 * 负数情况如何处理？
 */
public class MaximumDifference {
    public static void main(String[] args) {
//        int[] arr = CommonUtil.arrGenerator(10, -50, 50);
//        int[] arr = new int[]{12, 0, -15, -43, 42, 31, -50, 11, 27, 46};
        int[] arr = new int[]{7,1,5,5,5,5,5,5,6};
        CommonUtil.print(arr);
        Arrays.sort(arr);
        CommonUtil.print(arr);
        System.out.println("最大差值：" + maximumDifference(arr));
    }

    public static int maximumDifference(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return calculate(arr);
    }

    private static int calculate(int[] arr) {
        Bucket[] buckets = new Bucket[arr.length + 1];
        int maximumDifference = Integer.MIN_VALUE;
        int arrMax = Integer.MIN_VALUE;
        int arrMin = Integer.MAX_VALUE;
        //查找最大最小值
        for (int i = 0; i < arr.length; i++) {
            arrMax = Math.max(arrMax, arr[i]);
            arrMin = Math.min(arrMin, arr[i]);
        }
        if(arrMax==arrMin){
            return 0;
        }
        //放置每个数据到对应的桶里面
        for (int i = 0; i < arr.length; i++) {
            //查找哪个桶
            int bucketsIdx = (arr[i] - arrMin) * arr.length / (arrMax - arrMin);
            buckets[bucketsIdx] = (buckets[bucketsIdx] == null ? new Bucket() : buckets[bucketsIdx]);
            buckets[bucketsIdx].minValue = Math.min(buckets[bucketsIdx].minValue, arr[i]);
            buckets[bucketsIdx].maxValue = Math.max(buckets[bucketsIdx].maxValue, arr[i]);
            buckets[bucketsIdx].isNotEmpty = true;
            System.out.println("bucketsIdx:" + bucketsIdx + " minV：" + buckets[bucketsIdx].minValue + " MaxV:" + buckets[bucketsIdx].maxValue + " arr[" + i + "]" + arr[i]);
        }

        CommonUtil.print(buckets);
        //遍历桶找到两个非空桶之间的最大差值
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] != null && buckets[i].isNotEmpty) {
                Bucket lastNotEmptyBucket = findLastNotEmptyBucket(buckets, i);
                maximumDifference =
                        Math.max(buckets[i].minValue - lastNotEmptyBucket.maxValue, maximumDifference);
            }
        }
        return maximumDifference;
    }

    /**
     * 这个方法实现后时间复杂度就上升到了O(n<sup>2</sup>)
     *
     * @param buckets
     * @param i
     * @return
     */
    private static Bucket findLastNotEmptyBucket(Bucket[] buckets, int i) {
        while (i > 0) {
            if (buckets[--i] != null && buckets[i].isNotEmpty) {
                return buckets[i];
            }
        }
        return buckets[0];
    }

    static class Bucket {
        private int maxValue;
        private int minValue;
        private boolean isNotEmpty;

        public Bucket() {
            maxValue = Integer.MIN_VALUE;
            minValue = Integer.MAX_VALUE;
            isNotEmpty = false;
        }

        @Override
        public String toString() {
            return "Bucket{" +
                    "maxValue=" + maxValue +
                    ", minValue=" + minValue +
                    ", isNotEmpty=" + isNotEmpty +
                    '}';
        }
    }
}
