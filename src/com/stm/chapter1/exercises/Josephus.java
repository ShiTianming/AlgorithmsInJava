package com.stm.chapter1.exercises;

/**
 * Author STM
 * Create 4/9/19 11:49 PM
 * <p>
 * 约瑟夫问题
 * N个人围成一圈，从第一个人开始报数，报到m的人出圈，剩下的人从1开始继续报数；如此往复，直到所有人出圈
 */
public class Josephus {
    public static void main(String[] args) {
//        solution01(7, 2);   // 2	4	6	1	5	3	7
        solution02(7, 2);
    }


    private static void solution01(int count, int doom) {
        int alive = count;                  // 幸存人数
        int number = 0;                     // 计数器，当number == doom 出圈
        int index = 0;                      // 下标，从0开始
        int[] circle = new int[count];      // 数组，默认为0，即0表示在圈内，1表示出圈

        // 只要幸存人数大于0，就继续循环
        while (alive > 0) {
            number += 1 - circle[index];    //累计（number 1表示在圈内，0表示出圈）
            /*
             * 淘汰一个人的步骤：
             * 1. 该人的number == doom，输出该人的index + 1
             * 2. 将该人的状态标为1
             * 3. 幸存人数减1
             * 4. 计数器归0
             */
            if (number == doom) {
                System.out.print(index + 1 + "\t");
                circle[index] = 1;
                alive--;
                number = 0;
            }
            /*
             * 从下一位开始，所以为 index+1
             * 为了维持数组循环，和总人数取余（假设10个人，当序列号为9时，下一个人的序列号就为0）
             */
            index = (index + 1) % count;
        }
    }

    private static void solution02(int count, int doom) {
        int result = doom;
        for(int i = count; i >= doom; i--) {
            for (int j = i; j <= count; j++) {
                result = (result + doom) % j;
                System.out.print(result + 1 + "\t");
            }
        }
    }


}
