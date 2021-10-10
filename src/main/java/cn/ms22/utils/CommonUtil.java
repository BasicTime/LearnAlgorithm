package cn.ms22.utils;

import cn.ms22.exception.SortException;

import java.util.Arrays;


public final class CommonUtil {
    public enum Order {DESC, ASC}

    public static void print(int[] arr) {
        System.out.print("arr length\t" + arr.length + "\t:");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.print("\n");
    }

    public static void print(int[] arr, String prefix) {
        System.out.print(prefix + "\0");
        print(arr);
    }

    public static <T> void print(T[] arr) {
        for (T t : arr) {
            System.out.println(t.toString());
        }
    }

    public static <T> void print(T[] arr, String pre) {
        System.out.print(pre + "\n");
        print(arr);
    }


    public static int[] arrGenerator(int size) {
        return arrGenerator(size, 100);
    }

    /**
     *
     * @param size arr.length
     * @param lSection 左区间
     * @param rSection 右边区间
     * @return [lSection,rSection]
     */
    public static int[] arrGenerator(int size, int lSection, int rSection) {
        if (rSection <= 0) {
            rSection = 100;
        }
        if (lSection >= rSection) {
            rSection = 100;
            lSection = 0;
        }
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = lSection + (int) (Math.random() * (rSection - lSection + 1));
        }
        return arr;
    }


    public static int[] arrGenerator(int size, int section) {
        return arrGenerator(size, -section, section);
    }

    public static void comparator(int[] original, int[] last, Order... order) {
        if (order.length == 0) {
            Arrays.sort(original);
            comparator1(original, last);
        } else {
            switch (order[0]) {
                case ASC: {
                    Arrays.sort(original);
                    comparator1(original, last);
                }
                break;
                case DESC: {
                    Arrays.sort(original);
                    int[] clone = original.clone();
                    for (int i = 0; i < clone.length; i++) {
                        original[i] = clone[clone.length - 1 - i];
                    }
                    comparator1(original, last);
                }
                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + order[0]);
            }
        }
    }


    public static void swap(int[] arr, int idxa, int idxb) {
        int tmp = arr[idxa];
        arr[idxa] = arr[idxb];
        arr[idxb] = tmp;
    }

    public static void swap1(int[] arr, int idxa, int idxb) {
        arr[idxa] = arr[idxa] ^ arr[idxb];
        arr[idxb] = arr[idxa] ^ arr[idxb];
        arr[idxa] = arr[idxa] ^ arr[idxb];
    }

    private static void comparator1(int[] original, int[] last) {
        for (int i = 0; i < original.length; i++) {
            if (original[i] != last[i]) {
                System.out.println("结果有差异排序功能有误。");
                throw new SortException("结果有差异排序功能有误.");
            }
        }
    }
}


