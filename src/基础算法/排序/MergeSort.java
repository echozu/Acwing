package 基础算法.排序;

import java.util.Arrays;

//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int arr[]=new int[]{3,5,7,9,3,4,1};
        int[] end = merge_sock(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(end));
    }
    static int[] merge_sock(int arr[],int left,int right){
        if (left>=right){
            return arr;
        }
        int mid=right+left >>1;
        //先递归分区间
       arr= merge_sock(arr,left,mid);
        arr=merge_sock(arr,mid+1,right);
        //定义存储答案的数组
        int[] temp=new int[right-left +1];
        int k=0;
        //定义左右指针，分别执行两个区间的开始位置
        int i=left;
        int j=mid+1;
        //准备进行排序，将小的先放近数组里面
        //判断条件：是i在左区间内，j在右区间内，所以条件是i<=mid和j<=right;
        //为什么是=呢？因为mid也是属于左区间内的，所以是=
        while (i<=mid&&j<=right){
            //判断哪个比较小，小的先放进数组里面，然后再移动指针
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            } else{
                temp[k++]=arr[j++];
            }
        }
        //有可能是没排完的，那么又因为是已经排位序的了，所以依次放进去即可
        //为什么是=呢？因为如果i没有指向mid的话，那么就表示mid还没放进数组里面，所以需要i<mid
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=right){
            temp[k++]=arr[j++];
        }
        //然后将temp重新赋值给arr，方便下次递归排序
        //todo：注意这里的i和j的范围：
        //  这里是先从arr的left开始去改变，避免重复和覆盖。
        for (i=left,j=0;i<=right;i++,j++) {
            arr[i]=temp[j];
        }
        return arr;
    }
    static int[] merge_sock2(int arr[],int left,int right){
        if(left>=right){
            return arr;
        }
        int mid=right+left>>1;
        //先递归，想一下最终形态：其实就是两个数，然后要进行比较
        merge_sock2(arr,left,mid);
        merge_sock2(arr,mid+1,right);
        //定义一个答案数组
        int[]temp=new int[right-left+1];
        int k=0;
        int i=left;
        int j=mid+1;
        while (i<=mid&&j<right){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else {
                temp[k++]=arr[j++];
            }
        }
        //将剩余的区间的东西补充到temp中
        while (i<=mid&&j<=right){
            temp[k++]=arr[i++];
        }
        while (j<=right){
            temp[k++]=arr[j++];
        }
        //为什么i=left呢？因为上面的arr[i]是从left开始变化的。
        for(i=left,j=0;i<right;i++,j++){
            arr[i]=temp[j];
        }
        return arr;
    }
    static int[] merge_sock3(int arr[],int left,int right){
        if(left>=right){
            return arr;
        }
        int mid=left+right>>1;
        merge_sock3(arr,left,mid);
        merge_sock3(arr,mid+1,right);
        int[] temp=new int[right-left+1];
        int k=0;
        //定义两指针
        int i=left;
        int j=mid+1;
        while (i<=mid&&j<right){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else {
                temp[k++]=arr[j++];
            }
        }
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=right){
            temp[k++]=arr[j++];
        }
        for(i=left,j=0;i<right;i++,j++){
            arr[i]=temp[j];
        }
        return arr;



    }


    }
