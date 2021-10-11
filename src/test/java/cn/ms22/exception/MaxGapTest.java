package cn.ms22.exception;

import cn.ms22.chapter3.MaxGap;
import cn.ms22.chapter3.MaximumDifference;
import cn.ms22.utils.CommonUtil;
import org.junit.Assert;
import org.junit.Test;

public class MaxGapTest {
    @Test
    public void test01() {
        for (int i = 0; i < 1000; i++) {
            int arr[] = CommonUtil.arrGenerator(20, -1000, 1000);
            Assert.assertEquals(MaxGap.calculator(arr), MaximumDifference.maximumDifference(arr));
        }
    }
}
