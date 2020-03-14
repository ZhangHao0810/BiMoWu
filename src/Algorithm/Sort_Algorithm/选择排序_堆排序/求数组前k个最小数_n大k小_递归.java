package Algorithm.Sort_Algorithm.选择排序_堆排序;

import java.util.ArrayList;

/**
 * @author ZhangHao
 * @date 2020/3/10 20:03
 * @Description： n大 k小的时候. 求一个数组的前k个最小值.
 */

public class 求数组前k个最小数_n大k小_递归 {
    public static void main(String[] args) {
        int[] str = {7, 3, 8, 11, 12, 13, 15, 4, 5, 1, 6, 2, 16, 17, 18, 24, 26, 28, 29, 31, 33};
        求数组前k个最小数_n大k小_递归 s = new 求数组前k个最小数_n大k小_递归();
        System.out.print(s.getLeastNumbers(str, 4));
    }

    private ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        ArrayList<Integer> array = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return array;
        }
//        从k的父亲开始,到 根节点.循环. 将前k个从大到小排序.
        for (int i = (k - 1) / 2; i >= 0; i--) {
            buildMaxHeapSort(input, i, k);
        }
//        从k开始,到最后循环.
        for (int j = k; j < input.length; j++) {
//            小于根节点,就换 所以最大的根节点就被小的换了.
            if (input[j] < input[0]) {
                swap(input, 0, j);
//                再次对前k的元素进行大排序.大的往根部放. 这样搞到最后,前k个就是所有的最小的四个了. 但是还是由大到小排序的.
                buildMaxHeapSort(input, 0, k);
            }
        }
        //计算完毕，前k个进行小堆顶排序，然后输出
        for (int i = 0; i < k; i++) {
            heapSort(input, i, k);
            array.add(input[i]);
        }

        return array;
    }

    /**
     * 构建最大堆.
     *
     * @param input
     * @param i 从0 开始. 代表父亲. k表示限制.
     * @param k
     *
     *      函数每次调用只关注一个父亲和俩孩子, 但是函数内部有递归,
     */
    public void buildMaxHeapSort(int[] input, int i, int k) {

        int leftchild = 2 * i + 1;
        int rightchild = 2 * i + 2;
        // large 最大的插旗.
        int large = i;

//        将前k个元素, i的孩子 如果比i 大的话, 赋值给最大的插旗.

        if (leftchild < k && input[i] < input[leftchild]) {
            large = leftchild;
        }
        if (rightchild < k && input[large] < input[rightchild]) {
            large = rightchild;
        }
//        孩子比父亲大的话,就换一下. 此时还不能确定是大顶堆, 之后递归,所以就能把前k个元素从大到小排序.
        if (large != i) {
            swap(input, i, large);
            buildMaxHeapSort(input, large, k);
        }
    }

    /**
     * 小堆顶实现,最后输出的时候使用.
     *
     * @param input
     * @param root
     * @param end
     */
    private void heapSort(int[] input, int root, int end) {
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

    private void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

}


