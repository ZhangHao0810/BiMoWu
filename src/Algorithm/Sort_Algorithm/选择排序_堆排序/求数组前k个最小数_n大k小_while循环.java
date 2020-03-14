package Algorithm.Sort_Algorithm.选择排序_堆排序;

import java.util.ArrayList;

/**
 * @author ZhangHao
 * @date 2020/3/14 20:59
 * @Description： 另外一种实现.
 *
 *  一定一定要注意,堆排序的意义只是父亲比孩子大, 根是堆的最大值. 一个堆不一定是排好序的,想要达到排序的功能,需要多次创建堆, 就像冒泡排序需要多次冒泡一样.
 */
public class 求数组前k个最小数_n大k小_while循环 {
    /**
     * 最大堆
     *
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> getLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<Integer>();
        if (input == null || k <= 0 || k > input.length) {
            return leastNumbers;
        }
        //用于放最小的k个数
        int[] numbers = new int[k];
        for (int i = 0; i < k; i++) {
            //先放入前k个数
            numbers[i] = input[i];
        }
//注意这里的索引 函数输入是number 而不是input,其实用input更好.
        for (int i = k / 2 - 1; i >= 0; i--) {
            //将数组构造成最大堆形式,从k的父亲开始维护最大堆,一直到遍历到根节点.
//   因为我能确定,每一次堆排序 堆顶元素是最大的.所以k(如果是左孩子)  从根到k是递减的,如果k是右孩子,不能保证k与兄弟间的大小关系,不管没事儿 不影响功能.
            adjustHeap(numbers, i, k - 1);
        }
        for (int i = k; i < input.length; i++) {
            //存在更小的数字时,将第一个替换,然后再排序
            if (input[i] < numbers[0]) {
                numbers[0] = input[i];
                adjustHeap(numbers, 0, k - 1);
            }
        }
        for (int n : numbers) {
            leastNumbers.add(n);
        }
        return leastNumbers;
    }

    /**
     * 2020/3/14 21:07
     * 以start为根,以end为位置限制,构造大顶堆,注意大顶堆的数组序列不一定越前面越大,只是大顶堆的每个父亲都比自己的左右孩子都大.
     */
    private static void adjustHeap(int[] arr, int start, int end) {
        //记录父亲
        int temp = arr[start];
        //从0号排序,左孩子就是2*i+1
        int child = start * 2 + 1;
        //每次while只关注一个父亲和俩孩子.与Solution2时的算法不一样.Solution2用的递归,这里很巧妙的用了while循环.
        while (child <= end) {
            //右孩子>左孩子,选择右孩子
            if (child + 1 <= end && arr[child + 1] > arr[child]) {
                child++;
            }
            //如果最大的孩子<父亲 表示父亲最大,满足大顶堆的性质. 算是找到大顶堆,跳出.
            if (arr[child] < temp) {
                break;
            }
            //当前不是大顶堆,把最大的值(孩子)付给父亲.
            arr[start] = arr[child];
            //能走到这一步,说明还不确定是大顶堆,孩子变父亲 继续往下遍历.
            start = child;
            //左孙子变孩子.开始反复.
            child = child * 2 + 1;
        }
//        此时的start是满足大顶堆条件时,最后一次把父亲覆盖了的孩子.
// 所以执行下面赋值之前,有两个arr[start]值,所以把一开始的根,也就是比孩子,孙子都小的父亲, 即temp,放在合适的位置.
        arr[start] = temp;
    }

}
