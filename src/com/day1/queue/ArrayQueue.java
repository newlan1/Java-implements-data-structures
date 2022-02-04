package com.day1.queue;

/**
 * @author lance
 * @Description  使用数组模拟队列
 * @create 2022-02-04 22:26
 * @create 22:26
 * @Version v1.0
 */
public class ArrayQueue {
    public static void main(String[] args) {

    }
}



class ArrayQueueClass{

    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾部
    private int[] arr; //模拟队列

    //创建队列的构造器
    public ArrayQueueClass(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[this.maxSize]; //确定数组的最大容量
    }
}
