package com.tianjunwei.algorithm;

/**
 * 冒泡算法
 * @Description TODO
 * @Author tianjunwei7
 * @Date 2020/1/22 2:43 下午
 * @ClassName com.tianjunwei.algorithm
 */
public class Bubble {

    public static void  main(String [] args) {

        int [] bubbles = {3,4,1,2};
        Bubble.bubble(bubbles);
        for (int i = 0 ; i< bubbles.length ; i++) {
            System.out.println(bubbles[i]);
        }

    }

    public  static int[] bubble(int [] bubbles) {

        if(bubbles == null || bubbles.length == 0) {
            return bubbles;
        }

        int lenght = bubbles.length -1;

        for (int i = 0; i < lenght ; i++) {
            boolean flag = true;
            for (int j = 0; j < lenght -i ; j++) {
                if(bubbles[j] > bubbles[j+1]) {
                    int tmp = bubbles[j];
                    bubbles[j] = bubbles[j+1];
                    bubbles[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
        }
        return bubbles;
    }

}
