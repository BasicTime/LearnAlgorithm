package cn.ms22.chapter2;

import cn.ms22.utils.CommonUtil;

/**
 * 由8	3	6	1	0	4	-> 1, 3, 6, 1, 0, 4
 * 0位置的8变为了0位置的1，重新构造大根堆
 * 6	3	4	1	0	1
 */
public class HeapIfy {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 6, 1, 0, 4};
        CommonUtil.print(arr);
        //8	3	6	1	0	4
        heapIfy(arr, 0, arr.length - 1);

        CommonUtil.print(arr);
    }

    private static void heapIfy(int[] arr, int cur, int heapSize) {
        int left = cur * 2 + 1;
        while (left <= heapSize) {
            //左右叶子节点比较大小
            int largest = left + 1 <= heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //左右比较后在与头结点比较
            largest = arr[cur] > arr[largest] ? cur : largest;
            if (cur == largest) {
                return;
            }
            CommonUtil.swap(arr, cur, largest);
            cur = largest;
            left = cur * 2 + 1;
        }
    }

    private static void heapIfy(int[] arr, int cur) {
        int R = arr.length - 1;
        int maxIdx = R;
        while (cur <= R) {
            int left = cur * 2 + 1;
            int right = cur * 2 + 2;
            if (left > R) {
                return;
            }
            if (right <= R) {
                maxIdx = arr[cur] > arr[left] ? cur : left;
                maxIdx = arr[maxIdx] > arr[right] ? maxIdx : right;
                CommonUtil.swap(arr, maxIdx, cur);
            }
            if (right > R) {
                maxIdx = arr[cur] > arr[left] ? cur : left;
                CommonUtil.swap(arr, maxIdx, cur);
            }
            cur = maxIdx;
        }
    }

}
