package Algorithm.Sort_Algorithm.交换排序;

/**
 * @author ZhangHao
 * @date 2020/3/10 22:46
 * @Description： 交换排序_快排.  O(nlog2n)数量级中平均性能最好的.
 *
 *  快排是不稳定排序.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        QuickSort obj = new QuickSort();
        System.out.println("Start:");
        obj.print(a);
        int h=a.length-1;
        obj.quickSort(a, 0, h);
        System.out.println("After:");
        obj.print(a);
    }

    /** 2020/3/10 23:12
     * 每次递归,都能将基准(段首)元素放在合适的位置.. 最终遍历所有的.
    */
    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
//            将列表首元素放在合适位置或者说将基准元素放在合适位置.
            int middle=getMiddle(a,low,high);
//            对低子列表递归.
            quickSort(a, 0, middle - 1);
//            对高子列表递归.
            quickSort(a,middle+1,high);
        }
    }

    /** 2020/3/10 23:10
     * 返回首元素的合适位置,即 low与 high 之间 把 a[low] 放在合适的位置. 返回合适位置的索引.
     * 非常的吊!!!!!!!!
     *
     * high 末尾位置的索引.
    */
    private int getMiddle(int[] a, int low, int high) {
//        设置基准元素.a[low]
        int key = a[low];
        while (low < high) {
//            从high开始找比基准小的,赋值给a[low],此时a[high]重复. 此high非彼high
            while (low < high && a[high] >= key) {
                high--;
            }
            a[low] = a[high];
//            再从low开始找比基准大的,付给现在的a[high] ,现在a[low]重复.此low非彼low
            while (low < high && a[low] <= key) {
             low++;
            }
            a[high]=a[low];
        }
//        此时,low=high, 作为基准元素的位置.即key应该在的已经排序好的位置.
        a[low]=key;
        return low;
    }


    private void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
