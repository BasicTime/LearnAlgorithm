package cn.ms22.chapter4;

import cn.ms22.utils.CommonUtil;

public class Rotate {
    public static void main(String[] args) {
        Integer[][] arr55 = new Integer[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        Integer[][] arr44 = new Integer[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        Integer[][] arr = arr44;
        CommonUtil.print(arr);
        Rotate rotate = new Rotate();
        rotate.clockwise(arr);
        CommonUtil.print(arr, "转换1后：");
        rotate.clockwise(arr);
        CommonUtil.print(arr, "转换2后：");
        rotate.clockwise(arr);
        CommonUtil.print(arr, "转换3后：");
        rotate.clockwise(arr);
        CommonUtil.print(arr, "转换4后：");
    }

    private void clockwise(Integer[][] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        int startY = 0;
        int startX = 0;
        int endY = arr.length - 1;
        int endX = arr[0].length - 1;
        while (startY <= endY && startX <= endX) {
            clockwise(arr, startY++, startX++, endY--, endX--);
        }
    }

    private void clockwise(Integer[][] arr, int startY, int startX, int endY, int endX) {
        int times = endX - startX;
        System.out.println("endX,startX,times:" + endX + " " + startX + " " + times);
        //多点位同时交换，逆时针
        /*for (int i = 0; i < times; i++) {
            int tmp = arr[startY][startX + i];
            arr[startY][startX + i] = arr[startY + i][endX];
            arr[startY + i][endX] = arr[endY][endX - i];
            arr[endY][endX - i] = arr[endY - i][startX];
            arr[endY - i][startX] = tmp;
        }*/
        //顺时针
        for (int i = 0; i < times; i++) {
            int tmp = arr[startY][startX + i];
            arr[startY][startX + i] = arr[endY - i][startX];
            arr[endY - i][startX] = arr[endY][endX - i];
            arr[endY][endX - i] = arr[startY + i][endX];
            arr[startY + i][endX] = tmp;
        }
    }
}
