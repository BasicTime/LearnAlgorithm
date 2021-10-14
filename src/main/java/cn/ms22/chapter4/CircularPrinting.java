package cn.ms22.chapter4;

import cn.ms22.utils.CommonUtil;

public class CircularPrinting {
    private static final Integer[][] arr =
            //5*5
            /*new Integer[][]{{1, 2, 3, 4, 5},
                    {6, 7, 8, 9, 10},
                    {11, 12, 13, 14, 15},
                    {16, 17, 18, 19, 20},
                    {21, 22, 23, 24, 25}};*/
            //4*4
           /* new Integer[][]{{1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}};*/
    //5*3
            /*new Integer[][]{{1, 2, 3, 4, 5},
                    {6, 7, 8, 9, 10},
                    {11, 12, 13, 14, 15}};*/
    //6*4
            new Integer[][]{{1, 2, 3, 4, 5, 6},
                    {7, 8, 9, 10, 11, 12},
                    {13, 14, 15, 16, 17, 18},
                    {19, 20, 21, 22, 23, 24}};

    public static void main(String[] args) {
        CircularPrinting circularPrinting = new CircularPrinting();
        CommonUtil.print(circularPrinting.arr);

        circularPrinting.printEgg(arr);
    }

    /**
     * 该方法边界不好控制
     * @param arr
     */
    private void printing(Integer[][] arr) {
        for (int y = 0; y < arr.length; y++) {//竖向
            for (int x = 0; x < arr[y].length; x++) {//横向
//                System.out.print(arr[y][x]);
            }
        }
        int startX = 0, startY = 0, curY = 0, curX = 0;
        int verticalShaft = arr.length - 1;
        int crossShaft = arr[0].length - 1;
        //TODO 这里控制结束，但是结束条件没有控制住
        while (curX <= arr.length / 2 || curY <= arr[0].length / 2) {
            while (curX < crossShaft) {
                System.out.print(arr[curY][curX++] + "\t");
            }
            while (curY < verticalShaft) {
                System.out.print(arr[curY++][curX] + "\t");
            }
            while (curX > startX) {
                System.out.print(arr[curY][curX--] + "\t");
            }
            while (curY > startY) {
                System.out.print(arr[curY--][curX] + "\t");
            }
            curX++;
            curY++;
            startX++;
            startY++;
            verticalShaft--;
            crossShaft--;
        }
    }

    /**
     * 给定一个矩阵，和两个点,打印两个点构成的圈或线段或点
     * Y为纵向，X为横向
     *
     * @param arr
     * @param startY
     * @param startX
     * @param endY
     * @param endX
     */
    private void printEgg(Integer[][] arr, int startY, int startX, int endY, int endX) {
        if (startY == endY) {
            while (startX <= endX) {
                System.out.print(arr[startY][startX++] + "\t");
            }
        } else if (startX == endX) {
            while (startY <= endY) {
                System.out.print(arr[startY++][startX]);
            }
        } else {
            int curY = startY;
            int curX = startX;
            while (curX <= endX - 1) {
                System.out.print(arr[curY][curX++] + "\t");
            }
            while (curY <= endY - 1) {
                System.out.print(arr[curY++][curX] + "\t");
            }
            while (curX >= startX + 1) {
                System.out.print(arr[curY][curX--] + "\t");
            }
            while (curY >= startY + 1) {
                System.out.print(arr[curY--][curX] + "\t");
            }
        }
    }

    private void printEgg(Integer[][] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        int startY = 0;
        int startX = 0;
        int endY = arr.length - 1;
        int endX = arr[0].length - 1;
        while (startY <= endY && startX <= endX) {
            printEgg(arr, startY++, startX++, endY--, endX--);
        }
    }
}
