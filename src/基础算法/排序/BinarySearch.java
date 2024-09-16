package 基础算法.排序;

import java.util.Scanner;

//二分算法
public class BinarySearch {
    public static void main(String[] args) {
    sqrt();
    }

    private static boolean check(int x) {
        /* ... */
        return true;
    }

    //todo:整数二分
    //向左搜索,所以满足时变得是右
    static int leftBinarySearch(int[] arr, int left, int right) {
        //todo：这里的left<right也是固定的，即二分结束的条件就是left>=right，其实这也表示了二分完了
        while (left < right) {
            // 定义mid
            int mid = arr[left + right >> 1];
            if (check(mid)) {
                //如果满足性质，因为要找到左边第一个满足的，所以是向左搜索，所以此时缩小范围，right=mid
                right = mid;
            } else {
                //如果判断不成立，因为要找到左边第一个满足的，则应该扩大范围，向右找第一个满足的，所以是left=mid+1
                left = mid + 1;
            }
        }
        //todo:这里的left其实即为所求，即不断二分，最好找的的位置就是left所在位置
        return left;
    }

    //右边界：想右搜索，所以满足时变得是左
    //寻找右侧最后一个满足条件的数
    static int rightBinarySearch(int[] arr, int left, int right) {
        while (left < right) {
            //todo：如果下面是left=mid则这里有+1,所以下面有-1
            int mid = arr[left + right + 1 >> 1];
            if (check(mid)) {
                //如果满足条件，则需要向右搜索，找寻最后一个满足的，所以应该是left=mid
                left = mid;
            } else {
                //如果不满足，则需要向左搜索，找寻最后一个满足的
                right = mid - 1;
            }
        }
        return left;
    }

    //todo:浮点数二分
    // 检查x是否满足某种性质
    private static boolean check(double x) {
        return true;
    }

    // eps 表示精度，取决于题目对精度的要求，默认负六次方
    //经验：如果题目要求保留6为小数，即-6次方，如果要精度没有问题，可以多加两个，即变成-8次方，这样子精度就没有问题了

    private static double floatBinarySearch(double left, double right) {
        while (left < right) {
            double mid = (left + right) / 2;
            if (check(mid)) {
                //当满足性质时，证明答案在left-mid之间，所以可以让mid=right，减少范围
                right = mid;
            } else {
                //当不满足性质时，证明答案在mid-right之间，所以可以让left=mid；
                left = mid;
            }
        }
        return left;
    }


    //寻找左边第一个出现的
    static int left(int[] arr, int left, int right) {
        while (left < right) {
            int mid = arr[left + right << 1];

            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int right(int[] arr, int left, int right) {
        while (left < right) {
            int mid = arr[left + right + 1 << 1];
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    //todo：整数二分例题：寻找数的范围

    //这个数组就是例题给的有序数组：如：【1，3，3，4，5，6，7，8，9，9】
    //target就是要寻找的数组

    //返回值就是对应的索引位置：起始位置和最后位置
    private static int[] binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result[] = new int[2];
        //先去找到第一个数字出现的索引位置，其实就是左边界
        while (left < right) {
            int mid = arr[(left + right) / 2];
            //判断条件就是：看看是否比target大，因为是有序的，如果比他大则证明在范围内，要找到第一个得向左搜索
            if (mid >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //最后得到·的left就是target所在的索引,如果不相等则证明数组内没有所求的target，返回默认值-1，-1；
        if (arr[left] != target) {
            return new int[]{-1, -1};
        }
        result[0] = left;
        left = 0;
        right = arr.length;
        //找到有边界：最后一个出现的位置
        while (left < right) {
            int mid = arr[(left + right + 1) / 2];
            //如果判断成立，则代表在范围内，因为要找到最后一个，所以得向右移动
            if (mid > target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        result[1] = left;
        return result;
    }

    //todo：浮点数二分例题：数的三次方根

    /*给定一个浮点数 n，求它的三次方根。*/
    static double sqrt(){
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        //搜索区间的最小可能值。
        Double left = -Double.MAX_VALUE;
        //搜索区间的最大可能值。
        Double right = Double.MAX_VALUE;
        //todo:这里是精度问题：其实也是left<right,但是这里加了精度，即要保留8位小数
        while (right - left > 1e-8){
            double mid=(left+right)/2;
            if(mid * mid * mid >= x){
                right=mid;
            }else {
                left=mid;
            }
        }
        // todo:注意格式化输出字符串；保留六位小数
        System.out.printf("%.6f", left);
        return left;
    }

}
