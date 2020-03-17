package Algorithm.二_Sort_Algorithm.选择排序_堆排序;

import java.util.ArrayList;

/**
 * @author ZhangHao
 * @date 2020/3/10 18:50
 * @Description： 问题：输入n个整数，找出其中最小的K个数
 */
public class 求数组前k个最小数 {
    /* 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，
     * 则最小的4个数字是1,2,3,4,。
     * */

    private ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length) {
            return result;
        }
        print(input);
        //只排前k次
        for (int i = 0; i < k; i++) {
            //进行第i次排序
            heapSort(input, i, input.length);
            print(input);
            result.add(input[i]);
        }
        return result;

    }

    /** 2020/3/10 19:56
     * 小顶堆实现,思路是找父母, 每运行一次,能得到一个合适位置,就像冒泡排序.
    */

    private void heapSort(int[] input, int root, int end) {
//        从最后遍历所有的点.
        for (int j = end - 1; j >= root; j--) {
            //算出j节点的双亲节点的序号
            int parent = (j + root - 1) / 2;
            //双亲节点大于当前节点，交换位置。
            if (input[parent] > input[j]) {
                int temp = input[j];
                input[j] = input[parent];
                input[parent] = temp;
            }

        }

    }

    private void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");

        }
        System.out.println();

    }

    public static void main(String[] args) {
        int[] str = {4, 5, 1, 6, 2, 7, 3, 8};
        求数组前k个最小数 s = new 求数组前k个最小数();
        System.out.print(s.getLeastNumbers_Solution(str, 4));

    }

}



