package com.day1.queue;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Scanner;

/**
 * @author lance
 * @Description
 * @create 2022-02-05 20:01
 * @create 20:01
 * @Version v1.0
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");
        // 创建一个环形队列
        CircleArray queue = new CircleArray(4); //说明设置 4, 其队列的有效数据最大是 3
        int res;
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
         boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.getAllQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据 try {
                    res = queue.exportQueue();
                    System.out.printf("取出的数据是%d\n", res);
                    break;

            case 'h': // 查看队列头的数据
                try {
                    res = queue.headQueue();
                    System.out.printf("队列头的数据是%d\n", res);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 'e': // 退出
                scanner.close();
                loop = false;
                break;
            default:
                break;
        }
    }
        System.out.println("程序退出~~");
}}


class CircleArray {
    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾部
    private int[] arr; //模拟队列

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满不能加入数据");
            return;
        }

        arr[rear] = n;
        //将rear后移
        rear = (rear + 1) % maxSize;
    }


    //获取数据出队列
    public int exportQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法输出");
        }

        int value = arr[front];

        //将front后移
        front = (front + 1) % maxSize;

        return value;

    }


    //显示队列的所有数据
    public void getAllQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法输出");
        }
        for (int i = front; i <= front + size(); i++) {
            System.out.println("arr[" + i % maxSize + "]=" + arr[i % maxSize]);
        }
    }

    //求出当前队列的有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("headqueue:队列为空，无法输出");
        }

        return arr[front];

    }

}
