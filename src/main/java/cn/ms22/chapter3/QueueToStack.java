package cn.ms22.chapter3;

/**
 * 队列是先进先出（FIFO）
 * 队列有两个指针
 * 队列有add、pull操作
 * 栈有push、pop、peek操作
 * 栈只有一个指针
 * 目前这种实现，是定义了两个无差别的Queue，如果是peek方法的话，比较笨重，始终保持只有任意一个queue有数据，另一个为空。
 * 第二种实现，定义一个DataQueue，一个helpQueue，DataQueue始终指向数据所在Queue，help始终指向需要pop、peek的数据（
 * 始终保证有有一个数据，做peek时，很方便，只用判断是否有值，有值直接返回，不用来回倒腾。如果是做pop的话，就冲DataQueue倒腾到
 * helpQueue，然后把引用helpQueue和DataQueue交换一下，就又恢复到了DataQueue保存数据区，helpQueue保存辅助数据）
 */
public class QueueToStack {
    private int size;
    private CustomQueue<Integer> oneQueue, dataQueue;
    private CustomQueue<Integer> secQueue, helpQueue;

    public QueueToStack(int size) {
        this.size = size;
        oneQueue = dataQueue = new CustomQueue<>(size);
        secQueue = helpQueue = new CustomQueue<>(size);
    }

    public static void main(String[] args) {
        QueueToStack queueToStack = new QueueToStack(4);
        queueToStack.push(1);
        queueToStack.push(2);
        queueToStack.push(3);
        queueToStack.push(4);
        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.peek());
        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.peek());
        System.out.println(queueToStack.pop());
        queueToStack.push(5);
        queueToStack.push(6);
        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.peek());
        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.peek());
        System.out.println(queueToStack.pop());
        //测试空
//        System.out.println(queueToStack.pop());
        //测试满
//        queueToStack.push(7);
//        queueToStack.push(8);
//        queueToStack.push(9);
//        queueToStack.push(10);
//        queueToStack.push(11);
    }

    public void push(int v) {
        if (oneQueue.size() == size || secQueue.size() == size) {
            throw new RuntimeException("full.");
        }
        if (oneQueue.isEmpty()) {
            secQueue.add(v);
        } else {
            oneQueue.add(v);
        }
    }

    public int pop() {
        if (secQueue.isEmpty() && oneQueue.isEmpty()) {
            throw new RuntimeException("empty.");
        }
        if (secQueue.isEmpty()) {
            int len = oneQueue.size();
            for (int i = 0; i < len - 1; i++) {
                secQueue.add(oneQueue.poll());
            }
            return oneQueue.poll();
        } else {
            int len = secQueue.size();
            for (int i = 0; i < len - 1; i++) {
                oneQueue.add(secQueue.poll());
            }
            return secQueue.poll();
        }
    }

    public int peek() {
        if (secQueue.isEmpty() && oneQueue.isEmpty()) {
            throw new RuntimeException("empty.");
        }
        if (secQueue.isEmpty()) {
            int len = oneQueue.size();
            for (int i = 0; i < len - 1; i++) {
                secQueue.add(oneQueue.poll());
            }
            secQueue.add(oneQueue.peek());
            return oneQueue.poll();
        } else {
            int len = secQueue.size();
            for (int i = 0; i < len - 1; i++) {
                oneQueue.add(secQueue.poll());
            }
            oneQueue.add(secQueue.peek());
            return secQueue.poll();
        }
    }
}
