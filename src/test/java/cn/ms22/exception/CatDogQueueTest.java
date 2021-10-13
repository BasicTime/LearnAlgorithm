package cn.ms22.exception;

import cn.ms22.utils.CommonUtil;
import org.junit.Test;

public class CatDogQueueTest {
    @Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            int L = 2;
            int R = 5;
            System.out.println((int) (L + Math.random() * (R - L + 1)));
        }

    }
}
