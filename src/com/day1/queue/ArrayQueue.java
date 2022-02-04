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
        new ArrayQueueClass(10);
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
        front=-1;
        rear=-1;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull())
        {
            System.out.println("队列满不能加入数据");

        }
        rear++;
        arr[rear]=n;

    }
    //获取数据出队列
    public int exportQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法输出");
        }
                return arr[++front];
    }

    //显示队列的所有数据
    public void getAllQueue(){
        if(isEmpty())
        {
            throw new RuntimeException("队列为空，无法输出");
        }
        for (int i:arr)
        {
            System.out.println("arr["+i+"]="+arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue(){
        if(isEmpty())
        {
            throw new RuntimeException("队列为空，无法输出");
        }
        return arr[front+1];

    }


}
