package Algorithm.Sort_Algorithm.基数排序;

import java.util.Arrays;

/**
 * @author ZhangHao
 * @date 2020/3/12 22:32
 * @Description： * 基数排序是一种当关键字为整数类型时非常高效的排序方法。
 * *     基本思想是：设待排序的数据元素关键字是m位d进制整数（不足m位的关键字在高位补0）
 * * 设置d个桶，令其编号分别为0,1,2.... d-1
 * *     首先，按关键字最低位的数值一次把各数据元素放到相应的桶中
 * *     然后，按照桶号从小到大和进入桶中数据元素的先后次序收集分配在各桶中的数据元素，
 * * 这样就形成了数据元素集合的一个新的排列，此为一次基数排序。重复m次，就得到了排好序
 * * 的数据元素序列
 * *
 */
public class MultiKeyRadixSortTest {
    //基于计数排序的基数排序算法
    private static void radixSort(int[] array, int radix, int distance) {
        //array为待排序数组
        //radix，代表基数
        //distance 代表排序元素的位数

        int length = array.length;
        int[] temp = new int[length];//用于暂存元素
        int[] count = new int[radix];//用于计数排序
        int divide = 1;

        for (int i = 0; i < distance; i++) {

            //  将array中的元素完全复制到temp数组中
            System.arraycopy(array, 0, temp, 0, length);
            // 重置count数组，开始统计下一个关键字
            Arrays.fill(count, 0);

            // 计算每个待排序数据的子关键字
            for (int j = 0; j < length; j++) {
                int tempKey = (temp[j] / divide) % radix;
                count[tempKey]++;
            }

            for (int j = 1; j < radix; j++) {
                count[j] = count[j] + count[j - 1];
            }

            //个人觉的运用计数排序实现计数排序的重点在下面这个方法
            // 按子关键字对指定的数据进行排序
            for (int j = length - 1; j >= 0; j--) {
                int tempKey = (temp[j] / divide) % radix;
                count[tempKey]--;
                array[count[tempKey]] = temp[j];
            }

            divide = divide * radix;

        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] array = {3, 2, 3, 2, 5, 333, 45566, 2345678, 78, 990, 12, 432, 56};
        radixSort(array, 10, 7);
        for (int i = 0; i < array.length; i++) {
            System.out.print("  " + array[i]);
        }

    }

}
