package com.day1.SparseArray;

/**
 * @author lance
 * @Description
 * @create 2022-02-02 15:56
 * @create 15:56
 * @Version v1.0
 */
public class SparseArray {
    public static void main(String[] args) {

        System.out.println("原始的二维数组：");
        //创建一个原始的二维数组11*11
        int[][] chessboardArray=new int[11][11];
        chessboardArray[1][2]=1;
        chessboardArray[2][3]=2;

        //使用增强for循环输出
        for(int[] row:chessboardArray) {
            for (int item : row)
            {
                System.out.print("\t"+item);
            }
            System.out.println();
        }

        //将二维数组转为稀疏数组
        //1.先遍历得到非0的个数
        int sum=0;
        for(int i=0;i<chessboardArray.length;i++)
        {
            for (int j = 0; j < chessboardArray.length; j++) {
                if(chessboardArray[i][j]!=0)
                {
                    sum++;
                }

            }

        }
        System.out.println("数组中非0的元素个数："+sum);

        //创建对应的稀疏数组
        int[][] sparseArray=new int[sum+1][3];
        //给稀疏数组赋值
        //初始化第一行
        sparseArray[0][0]=chessboardArray.length;
        sparseArray[0][1]=chessboardArray.length;
        sparseArray[0][2]=sum;
        //初始化n+1行
        int count=0;
        for(int i=0;i<chessboardArray.length;i++)
        {
            for (int j = 0; j < chessboardArray.length; j++) {
                if(chessboardArray[i][j]!=0)
                {
                    count++;
                    sparseArray[count][0]=i; //坐标
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessboardArray[i][j]; //实际元素的值
                }

            }

        }


        System.out.println("输出稀疏数组：");

        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray.length; j++) {
                System.out.print("\t"+sparseArray[i][j]);
            }
            System.out.println();
        }

        /************稀疏数组转换为二维数组************/

        //先读取行和列
        int[][] newChessboardArray=new int[sparseArray[0][0]][sparseArray[0][1]];
        //填充 回二维数组
        for (int i = 1; i < sparseArray.length; i++) {
            newChessboardArray[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
            }

        System.out.println("输出稀疏数组转换为二维数组：");
        for( int[] row:newChessboardArray)
        {
            for (int item:row)
            {
                System.out.print("\t"+item);

            }
            System.out.println();
        }



    }
}
