package com.day1.linkedList;/**
@author lance
@Description 
@create 2022-02-06 17:49
@create 17:49
@Version v1.0
*/public class SingleLinkedList {
    public static void main(String[] args) {
        SingleLinked singleLinked = new SingleLinked();
        HeroNode heroNode1=new HeroNode(1,"李逵","1001");
        HeroNode heroNode2=new HeroNode(3,"吴用","1002");
        HeroNode heroNode3=new HeroNode(2,"关胜","1003");
        HeroNode heroNode4=new HeroNode(4,"花荣","1004");
        HeroNode heroNode5=new HeroNode(3,"宋江","1005");


        singleLinked.add_ordered(heroNode1);
        singleLinked.add_ordered(heroNode2);
        singleLinked.add_ordered(heroNode3);
        singleLinked.add_ordered(heroNode4);
        singleLinked.update(heroNode5);
        singleLinked.delete(1);

        singleLinked.allList();
    }
}

class SingleLinked{

    private HeroNode head=new HeroNode(0,"0","0");

    //添加
    public void add(HeroNode heroNode)
    {
        HeroNode temp=head;
        //当循环执行完毕时 temp一定指向链表的最后
        while (true)
        {


            //找到了链表的最后
            if(temp.next==null) {
                break;
            }
            //如果没有找到 就后移
            temp=temp.next;
        }
        //将最后的节点指向
        temp.next=heroNode;
    }

    //显示链表
    public void allList(){

        //判断一下链表是否为空
        if(head.next==null){

            System.out.println("链表为空");
            return;
        }



        HeroNode temp=head.next;

        while (true){

            if(temp==null){
                break;
            }


            System.out.println(temp.toString());

            //后移
            temp=temp.next;


        }


    }


    //顺序添加
    public void add_ordered(HeroNode heroNode) {
        //

        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if(temp.next == null) {//说明temp已经在链表的最后
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
        } else{
            //插入到链表中
            heroNode.next=temp.next;
            temp.next=heroNode;
        }


        }


    //修改
    public void update(HeroNode newHeroNode)
    {
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }


        HeroNode temp=head;

        while (true){
            if(temp.next.no==newHeroNode.no){
                temp.next.name= newHeroNode.name;
                temp.next.nickname= newHeroNode.nickname;
                return;
            }
            //后移
            temp=temp.next;
        }

    }

    //删除
    public void delete(int id){
           HeroNode temp=head;
           while (true)
           {
               if(temp.next==null)
               {
                   System.out.println("无法删除 不存在！");
                    return;
               }

               if(temp.next.no==id)
               {
                   temp.next=temp.next.next;
                    return;
               }
           temp=temp.next;
           }

    }


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
