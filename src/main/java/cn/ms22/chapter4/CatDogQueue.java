package cn.ms22.chapter4;

import cn.ms22.utils.CommonUtil;

public class CatDogQueue {
    private Pet[] dogQueue;
    private Pet[] catQueue;
    private int catEndIdx;
    private int catStartIdx;
    private int dogEndInx;
    private int dogStartInx;
    private int dogSize;
    private int catSize;

    public CatDogQueue(int len) {
        dogQueue = new Pet[len];
        catQueue = new Pet[len];
    }

    public static void main(String[] args) {
        CatDogQueue catDogQueue = new CatDogQueue(3);
        catDogQueue.add(new Cat("Cat"));
        catDogQueue.add(new Cat("Cat"));
        catDogQueue.add(new Cat("Cat"));
        System.out.println(catDogQueue.getFirstCat());
        catDogQueue.add(new Cat("Cat"));
        catDogQueue.add(new Dog("Dog"));
        catDogQueue.add(new Dog("Dog"));
        catDogQueue.add(new Dog("Dog"));
        System.out.println(catDogQueue.getFirstDog());
        catDogQueue.add(new Dog("Dog"));
        System.out.println(catDogQueue.getFirstDog());
        catDogQueue.add(new Dog("Dog"));
        System.out.println(catDogQueue.getFirstDog());
        catDogQueue.add(new Dog("Dog"));

        CommonUtil.print(catDogQueue.getAll(), "end:");
    }

    public void add(Pet pet) {
        switch (pet.type.toUpperCase()) {
            case "CAT": {
                if (catSize == catQueue.length) {
                    throw new RuntimeException("cat queue full.");
                }
                if (catEndIdx == catQueue.length) {
                    catEndIdx = 0;
                }
                catQueue[catEndIdx++] = pet;
                catSize++;
            }
            break;
            case "DOG": {
                if (dogSize == dogQueue.length) {
                    throw new RuntimeException("dog queue full.");
                }
                if (dogEndInx == dogQueue.length) {
                    dogEndInx = 0;
                }
                dogQueue[dogEndInx++] = pet;
                dogSize++;
            }
            break;
            default:
                throw new RuntimeException("未知类型Pet。");
        }
    }

    public Pet getFirstCat() {
        if (catSize == 0) {
            throw new RuntimeException("empty");
        }
        Pet pet = catQueue[catStartIdx++];
        if (catStartIdx == catQueue.length) {
            catStartIdx = 0;
        }
        catSize--;
        return pet;
    }

    public Pet getFirstDog() {
        if (dogSize == 0) {
            throw new RuntimeException("empty");
        }
        Pet pet = dogQueue[dogStartInx++];
        if (dogStartInx == dogQueue.length) {
            dogStartInx = 0;
        }
        dogSize--;
        return pet;
    }

    public Pet[] getAll() {
        Pet[] all = new Pet[dogSize + catSize];
        int allIdx = 0;
        int catIdx = catStartIdx;
        int dogIdx = dogStartInx;

        int petSize = catSize;
        while (petSize > 0) {
            all[allIdx++] = catQueue[catIdx == catQueue.length ? 0 : catIdx];
            catIdx++;
            petSize--;
        }
        petSize = dogSize;
        while (petSize > 0) {
            all[allIdx++] = dogQueue[dogIdx == dogQueue.length ? 0 : dogIdx];
            dogIdx++;
            petSize--;
        }
        reset(all);
        return all;
    }

    private void reset(Pet[] all) {
        if (all == null || all.length < 2) {
            return;
        }
        sort(all, 0, all.length - 1);
    }

    private void sort(Pet[] all, int L, int R) {
        if (L < R) {
            CommonUtil.swap(all, (int) (L + Math.random() * (R - L + 1)), R);
            int[] partition = partition(all, L, R);
            sort(all, L, partition[0]);
            sort(all, partition[1], R);
        }
    }

    /**
     * 返回相等区域的左右边界
     *
     * @param all
     * @param L
     * @param R
     * @return
     */
    private int[] partition(Pet[] all, int L, int R) {
        Pet pet = all[R];
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while (cur < more) {
            if (all[cur].getId() < pet.getId()) {
                CommonUtil.swap(all, ++less, cur++);
            } else if (all[cur].getId() == pet.getId()) {
                cur++;
            } else {
                CommonUtil.swap(all, cur, --more);
            }
        }
        return new int[]{less, more};
    }

    public boolean catIsEmpty() {
        return catSize == 0;
    }

    public boolean dogIsEmpty() {
        return dogSize == 0;
    }

    static abstract class Pet {
        private String type;
        private long id;

        public abstract String amIs();

        public Pet(String type) {
            this.type = type;
            this.id = Generator.generateId();
        }

        protected long getId() {
            return id;
        }
    }

    static class Dog extends Pet {

        public Dog(String type) {
            super(type);
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "type='" + super.type + '\'' +
                    ", id=" + super.id +
                    '}';
        }

        @Override
        public String amIs() {
            return "dog";
        }
    }

    static class Cat extends Pet {

        @Override
        public String toString() {
            return "Cat{" +
                    "type='" + super.type + '\'' +
                    ", id=" + super.id +
                    '}';
        }

        public Cat(String type) {
            super(type);
        }

        @Override
        public String amIs() {
            return "cat";
        }
    }

    static class Generator {
        private static volatile long id = 0L;

        public synchronized static long generateId() {
            return id++;
        }
    }
}
