package cn.ms22.chapter2;

import cn.ms22.BaseSort;
import cn.ms22.utils.CommonUtil;

public class HeapSort extends BaseSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = heapSort.generator(20);
//        int[] arr = new int[]{6, 3, 8, 1, 0, 4};
//        heapSort.print(arr).sort(arr).print(arr, "end");
//        heapSort.compare(1000000, CommonUtil.Order.ASC);
        CommonUtil.print(arr);
        int[] original = arr.clone();
        new HeapSort().sort1(arr);
        CommonUtil.print(arr,"end");
        CommonUtil.comparator(original,arr, CommonUtil.Order.ASC);
    }

    @Override
    public BaseSort sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return this;
        }
        heapInsert(arr);
        swap(arr, 0, arr.length - 1);
        heapIfy(arr, 0, arr.length - 2);
        return this;
    }

    public void sort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        heapInsert(arr);
        int heapSize = arr.length;
        CommonUtil.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapIfy1(arr, 0, heapSize);
            CommonUtil.swap(arr, 0, --heapSize);
        }
    }

    private void heapIfy1(int[] arr, int cur, int heapSize) {
        int left = cur * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[cur] > arr[largest] ? cur : largest;
            if (cur == largest) {
                break;
            }
            CommonUtil.swap(arr, cur, largest);
            cur = largest;
            left = cur * 2 + 1;
        }
    }

    private void heapIfy(int[] arr, int start, int heapSize) {
        if (start >= heapSize) {
            return;
        }
        int left = start * 2 + 1;
        int cur = start;
        while (left <= heapSize) {
            int largest = left + 1 <= heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[cur] > arr[largest] ? cur : largest;
            if (cur == largest) {
                break;
            }
            swap(arr, cur, largest);
            cur = largest;
            left = cur * 2 + 1;
        }
        swap(arr, start, heapSize);
        heapIfy(arr, start, heapSize - 1);
    }

    private void heapInsert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = i;
            while (arr[cur] > arr[(cur - 1) / 2]) {
                swap(arr, cur, (cur - 1) / 2);
                cur = (cur - 1) / 2;
            }
        }
    }
}
