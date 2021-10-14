package cn.ms22.exception;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WildcardErrorTest<T extends Throwable> {
    void foo(@NotNull List<?> l) {
//        l.set(0, l.get(0));
        fooHelper(l);
    }

    private <T> void fooHelper(@NotNull List<T> l) {
        l.set(0, l.get(0));
    }

    @Test
    public void test01(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        new WildcardErrorTest().foo(list);
    }

    @Test
    public void test02() throws T{
        Object[] objects = new String[2];
        objects[0] = "String";
        try {
            objects[1] = 123;

        }catch (Exception e){

        }
//        List<Integer>[] arrayOfLists = new List<Integer>[2];
    }

}
