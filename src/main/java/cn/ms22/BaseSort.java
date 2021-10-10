package cn.ms22;

import cn.ms22.utils.CommonUtil;

public abstract class BaseSort {
    private final int lSection = -100;
    private final int rSection = -100;
    private final int size = 50;

    public abstract BaseSort sort(int[] arr);

    public BaseSort print(int[] arr) {
        CommonUtil.print(arr);
        return this;
    }

    public BaseSort print(int[] arr, String pre) {
        CommonUtil.print(arr, pre);
        return this;
    }

    protected BaseSort swap(int[] arr, int idxa, int idxb) {
        CommonUtil.swap(arr, idxa, idxb);
        return this;
    }

    protected int[] generator(int size) {
        return CommonUtil.arrGenerator(size);
    }

    protected int[] generator(int size, int lSection, int rSection) {
        return CommonUtil.arrGenerator(size, lSection, rSection);
    }

    protected void compare(int count, CommonUtil.Order order) {
        compare(count, lSection, rSection, order);
    }

    protected void compare(int count, int lSection, int rSection, CommonUtil.Order order) {
        for (int i = 0; i < count; i++) {
            int[] arr = generator(size, lSection, rSection);
            int[] arrOriginal = arr.clone();
            sort(arr);
            CommonUtil.comparator(arrOriginal, arr, order);
        }
    }
}
