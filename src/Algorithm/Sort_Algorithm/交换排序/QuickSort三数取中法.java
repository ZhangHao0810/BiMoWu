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
        quickSort(a, 0, h);
        System.out.println("After:");
        obj.print(a);
    }


    public static void quickSort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
//        获得基准值合适位置的索引.
        int index = partition(array, lo, hi);
        quickSort(array, lo, index - 1);
        quickSort(array, index + 1, hi);
    }

    public static int partition(int[] array, int lo, int hi) {
//        三数取中就是 将"段"的两端与中间元素三数排序 之后再getMiddle 也就是返回基准(首位)元素的合适位置.
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



    private void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
