package Algorithm.二_Sort_Algorithm.交换排序;

/**
 * @author ZhangHao
 * @date 2020/3/14 22:22
 * @Description： 算法复杂度 O(n)
 */
public class 求n个整数中最小的k个数_快排_输入数组可修改 {

    /**
     * 题目： 输入n个整数，找出其中最小的k个数。
     * input  输入数组
     * output 输出数组
     */
    public static void getLeastNumbers(int[] input, int k) {
        int[] output = new int[k];

        if (input == null || k <= 0 || k > input.length) {
            return ;
        }

        int start = 0;
        int end = input.length - 1;
//        获得基准值,目标是将基准值移动到k的位置.
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index < k - 1) {
                //前面筛选的不够,后面的接着筛选
                start = index + 1;
            } else {
                end = index - 1;
            }
//            重新获得基准值.
            index = partition(input, start, end);
        }
//将input copy给output.
        System.arraycopy(input, 0, output, 0, output.length);
    }

    /**
     * 分区算法
     *
     * @param input 输入数组
     * @param start 开始下标
     * @param end   结束下标
     * @return 分区位置
     */
    private static int partition(int[] input, int start, int end) {
        int tmp = input[start];

        while (start < end) {
            while (start < end && input[end] >= tmp) {
                end--;
            }
            input[start] = input[end];

            while (start < end && input[start] <= tmp) {
                start++;
            }
            input[end] = input[start];
        }

        input[start] = tmp;
        return start;
    }

}
