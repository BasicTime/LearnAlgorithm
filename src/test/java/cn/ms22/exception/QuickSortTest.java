package cn.ms22.exception;

import cn.ms22.utils.CommonUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSortTest {
    @Test
    public void testArr() {
        int less = -1, more = -1;
        int arr[] = new int[]{less, more};
        CommonUtil.print(arr);
        less = 10;
        more = 5;
        CommonUtil.print(arr);
    }


}
