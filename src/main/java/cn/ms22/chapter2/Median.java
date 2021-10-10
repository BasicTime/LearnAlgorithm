package cn.ms22.chapter2;

import cn.ms22.utils.CommonUtil;

import java.util.concurrent.TimeUnit;

public final class Median {
    /**
     * 预定义1000个原始数据
     */
    private int[] original;
    private final int size;
    private volatile int cur = 0;

    private Median(int size) {
        this.size = size;
        original = CommonUtil.arrGenerator(size);
    }

    public static void main(String[] args) {
        Receptor receptor = new Receptor(10);
        receptor.accept();

    }

    static class Receptor {
        public int getSize() {
            return size;
        }

        public int[] getBigHeap() {
            return bigHeap == null ? new int[size] : bigHeap;
        }

        public int[] getSmallHeap() {
            return smallHeap == null ? new int[size] : smallHeap;
        }

        private int size;
        private int[] bigHeap;
        private int[] smallHeap;

        public Receptor(int size) {
            this.size = size;
        }

        public void accept() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    //ignore
                }
                getMedian();
            }
        }

        public int getMedian() {
            Median median = new Median(100);
            //TODO fetch
            return -1;
        }

    }

    public int[] getOriginal() {
        return original;
    }

    public int getSize() {
        return size;
    }

    public synchronized int curIdxGetAndSet() {
        return ++cur;
    }

    public synchronized int curGet() {
        return cur;
    }

    public synchronized void curSet(int step) {
        this.cur += step;
    }
}
