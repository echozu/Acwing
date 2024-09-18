package 基础算法.排序;

//前缀和：求某个区间的和。避免遍历太多次
public class SumPrefix {
    private static final int N = 100010;
    private static final int[] a = new int[N + 5];
    private static final int[] s = new int[N + 5];

    //问题：求left-right区间的和。

    static void init(int n) {
        //注意：这里的i从1开始
        //这里先去计算一个前缀和的集合：s[n]=a[1]+a[2]+a[3]+a[4]+.....+a[n]
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + a[i];
        }
    }
    //根据询问的区间范围left和right得到区间的结果
    static int sumPrefix(int left,int right){
        //注意：这里求left-right区间的结果是s[right]-s[left-1]，有-1；
        return s[right]-s[left-1];
    }
}
