package com.day1.linkedList;

import java.util.Stack;

/**
@author lance
@Description 
@create 2022-02-06 17:49
@create 17:49
@Version v1.0
*/public class SingleLinkedList {
    public static void main(String[] args) {
        SingleLinked singleLinked = new SingleLinked();
        HeroNode heroNode1 = new HeroNode(1, "李逵", "1001");
        HeroNode heroNode2 = new HeroNode(3, "吴用", "1002");
        HeroNode heroNode3 = new HeroNode(2, "关胜", "1003");
        HeroNode heroNode4 = new HeroNode(4, "花荣", "1004");
        HeroNode heroNode5 = new HeroNode(5, "宋江", "1005");

        singleLinked.add_ordered(heroNode1);
        singleLinked.add_ordered(heroNode2);
        singleLinked.add_ordered(heroNode3);
        singleLinked.add_ordered(heroNode4);
        singleLinked.add_ordered(heroNode5);
        //singleLinked.update(heroNode5);
        //singleLinked.delete(1);

        singleLinked.allList();


        //System.out.println("有效个数为:" + SingleLinkedList.getLength(singleLinked.getHead()));
       // int index=3;

        //查到倒数第K个元素
        //System.out.println("查到倒数第"+index+"个元素为:" + findLastIndexNode(singleLinked.getHead(), index));

       // System.out.println("针对单链表的反转测试：");

       // reversetlist(heroNode1);

        System.out.println("反转后的单链表显示:");
        reversePrint(singleLinked.getHead());
       // singleLinked.allList();

    }
    //得到有效节点的个数
    public static int getLength(HeroNode head) {
        if (head.next == null) { //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next; //遍历
        }
        return length;
    }
    //查找倒数第K个元素的值  //新浪面试题
    public static HeroNode findLastIndexNode(HeroNode head, int index) {


        if (head.next == null) {
            return null;
        }


        HeroNode temp = head;
        int size = getLength(head);


        if (index <= 0 || index > size) {
            return null;
        }

        //定义辅助变量
        //指向第一个有效节点
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;

        }

        return cur;


    }

    //将单链表反转   腾讯面试题
    public static void reversetlist(HeroNode head){
        //当链表只有一个节点 或 没有节点时 不需要处理
        if(head.next==null|| head.next.next==null){
            return;

        }
        //定义一个辅助的指针  帮助我们遍历原来的链表
        HeroNode cur= head.next;
        HeroNode next=null;  //指向当前节点的下一个节点
        HeroNode reverseHead=new HeroNode(0,"","");

        //遍历
        while(cur!=null){
            next=cur.next; //先暂时保存当前节点的下一个节点
            cur.next=reverseHead.next; //将cur的下一个节点指向新的链表的头部
            reverseHead.next=cur;
            cur=next;//让cur后移
        }
        //将head.next指向reversehead.next  实现单链表的反转
        head.next=reverseHead.next;

    }


    //将单链表逆序  百度面试题
    public static void reversePrint(HeroNode head){

        HeroNode cur=head.next;


        Stack<HeroNode> stack=new Stack<>();

        while (cur!=null){
            stack.push(cur);

            cur=cur.next;
        }

        //打印
        while (stack.size()>0){
            System.out.println(stack.pop());
        }


    }

}



class SingleLinked {

    private HeroNode head = new HeroNode(0, "0", "0");

    public HeroNode getHead() {
        return head;
    }

    //添加
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        //当循环执行完毕时 temp一定指向链表的最后
        while (true) {


            //找到了链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到 就后移
            temp = temp.next;
        }
        //将最后的节点指向
        temp.next = heroNode;
    }

    //显示链表
    public void allList() {

        //判断一下链表是否为空
        if (head.next == null) {

            System.out.println("链表为空");
            return;
        }


        HeroNode temp = head.next;

        while (true) {

            if (temp == null) {
                break;
            }


            System.out.println(temp.toString());

            //后移
            temp = temp.next;


        }


    }


    //顺序添加
    public void add_ordered(HeroNode heroNode) {
        //

        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break; //
            }

            if (temp.next.no > heroNode.no)  //成立就把当前元素插入
            {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;  //编号存在
                break;
            }

            //后移
            temp = temp.next;
        }

        //判断flag的值
        if (flag) {
            //不能添加
            System.out.println("准备插入的英雄的标号已经存在:" + heroNode.no);
        } else {
            //插入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }


    }


    //修改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }


        HeroNode temp = head;

        while (true) {
            if (temp.next.no == newHeroNode.no) {
                temp.next.name = newHeroNode.name;
                temp.next.nickname = newHeroNode.nickname;
                return;
            }
            //后移
            temp = temp.next;
        }

    }

    //删除
    public void delete(int id) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("无法删除 不存在！");
                return;
            }

            if (temp.next.no == id) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

    }


    //判断单链表的节点的个数

    public static int getLength(HeroNode head)
    {
        if(head.next==null){
            return 0;
        }

        int length=0;

        //定义一个辅助变量
        HeroNode cur=head.next;
        while(cur!=null)
        {
            length++;
            cur=cur.next;
        }
        return length;
    }


    //新浪面试题  查找单链表中的倒数第K个节点



}






class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    ;
}
