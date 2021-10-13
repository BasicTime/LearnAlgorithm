package cn.ms22.chapter3;

/**
 * FIFO,从tail进入，从head出
 *
 * @param <T>
 */
public class CustomQueue<T> {
    private T[] arr;
    //当前队列里面放置了多少数据，这个不能通过head和tail计算出来，因为head和tail始终在往前走，并且达到arr.length时候，是会
    //回到arr[0]位置的。
    private int size;
    //始终放在需要出的数据上
    private int queueHead = 0;
    //始终指向需要添加数据的index
    private int queueTail = 0;

    public CustomQueue(int len) {
        arr = (T[]) new Object[len];
    }

    public static void main(String[] args) {
        CustomQueue<Integer> customQueue = new CustomQueue(10);
        for (int i = 0; i < 10; i++) {
            customQueue.add(i);
            System.out.println(customQueue.poll());
            customQueue.add(i);
            System.out.println("size:" + customQueue.size());
        }
    }

    public int size() {
        return size;
    }

    public T peek() {
        return arr[queueHead];
    }

    public T poll() {
        if (size == 0) {
            throw new RuntimeException("队列为空。");
        }
        T t;
        if (queueHead == arr.length - 1) {
            t = arr[queueHead];
            queueHead = 0;
        } else {
            t = arr[queueHead++];
        }
        size--;
        return t;
    }

    public void add(T t) {
        if (size == arr.length) {
            throw new NullPointerException("队列已经满了。");
        }
        if (queueTail == arr.length - 1) {
            arr[queueTail] = t;
            queueTail = 0;
        } else {
            arr[queueTail++] = t;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
