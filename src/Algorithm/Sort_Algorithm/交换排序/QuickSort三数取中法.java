package Algorithm.Sort_Algorithm.交换排序;

/**
 * @author ZhangHao
 * @date 2020/3/10 23:15
 * @Description： 若初始的序列有序或者基本有序时, 快排会蜕化为冒泡.需要改进. 用三者取中法.
 */
public class QuickSort三数取中法 {

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 7, 5, 4, 9, 6, 10, 8};
        QuickSort三数取中法 obj = new QuickSort三数取中法();
        System.out.println("Start:");
        obj.print(a);
        int h=a.length-1;
        sort(a, 0, h);
        System.out.println("After:");
        obj.print(a);
    }


    public static int partition(int[] array, int lo, int hi) {
//        三数取中. 就是把两边和中间这三个数排好序.
        int mid = lo + (hi - lo) / 2;
        if (array[mid] > array[hi]) {
            swap(array[mid], array[hi]);
        }
        if (array[lo] > array[hi]) {
            swap(array[lo], array[hi]);
        }
        if (array[mid] > array[lo]) {
            swap(array[mid], array[lo]);
        }

//        开始一般的快排.
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {
                lo++;
            }
            array[hi]=array[lo];
        }
//        跳出循环时,lo==high
        array[hi]=key;
        return hi;

    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }

    private void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
