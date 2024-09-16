package 基础算法.排序;
//快速排序

import java.util.Arrays;

//1.确定分界点
//2.将左右分界，即使得左边小于分界点，右边>分界点
//3.递归：将分号的左右区间，再次进行递归去分区，当直到分的区间里面只剩下一个数时，就代表其实已经排好序了
public class QuickSort {
    public static void main(String[] args) {
        int arr[]=new int[]{3,5,7,9,3,4,1};
        int[] end = quick_sock(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(end));

    }
    static int[] quick_sock(int[] arr, int left, int right){
        //如果数组里面只剩下一个数的话，不用排序
        if(left>=right){
            return arr;
        }
        //定义左右指针
        int i=left-1;
        int j=right+1;
        //取中间值
        int p=arr[left+right>>1];
        //这里的话是对数组进行分区间，即小于p的会被分到左边，大于p的会被分到右边【遗留：但是左右区间内部并没有排序好，所以需要进行递归】
        while (i<j){
            //先进行+1操作，因为上面的i和j取得是比左边前一位（-1），比右边多一位，所以需要先进入数组的索引范围
            //原因：当需要进行交换时，交换完是得向前走一步的，所以这样写时，当交换完，。那么也是需要先++/--，这样子就避免再进行操作
            do {
                i++;
            }while (arr[i]<p);
            do {
                j--;
            }while (arr[j]>p);
            //如果执行到下面这一步且i<j的话，那么就证明是需要交换的
            if(i<j){
                int num=arr[i];
                arr[i]=arr[j];
                arr[j]=num;
            }
        }
        //  todo：将结果赋值给 arr 的原因是因为数组在 Java 中是引用类型。
        // 当传递数组到一个方法中时，实际上是传递了数组的引用，即对数组arr的修改会直接修改了arr，而不是副本。

        //这里是将左右区间进行递归，使得区间内部也将排序：内核：其实就是将两个大区间分成无数小区间，直到当区间的只剩下一个数时
        //递归结束，逐渐返回，然后就得到两个已经排完序的区间了

        //𬣞
        quick_sock(arr,left,j);
        quick_sock(arr,j+1,right);
        return arr;
    }
    static int[] quick_sock2(int[]arr,int left,int right){
        if(left>right){
            return arr;
        }
        int i=left-1;
        int j=right+1;
        int p=arr[left+right >>1];
        while (i<j){
            do {
                i++;
            }while (arr[i]<p);
            do {
                j--;
            }while (arr[j]>p);
            if (i<j){
                int num=arr[i];
                arr[i]=arr[j];
                arr[j]=num;
            }
        }
        quick_sock(arr,left,j);
        quick_sock(arr,j+1,right);
        return arr;
    }
}

//再写一编

