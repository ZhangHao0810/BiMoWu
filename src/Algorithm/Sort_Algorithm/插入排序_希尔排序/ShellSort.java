package Algorithm.Sort_Algorithm.插入排序_希尔排序;

/**
 * @author ZhangHao
 * @date 2020/3/7 21:04
 * @Description： 插入排序之 希尔排序
 *      普通的插入排序,即将每一个元素插入已排好序的序列中, 循环判定每一个元素. O(n^2)
 * 从小到大排序.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        ShellSort obj = new ShellSort();
        System.out.println("初始值:");
        obj.print(a);
        obj.shellSort(a);
        System.out.println("\n排序后:");
        obj.print(a);
    }

    private void shellSort(int[] a) {
        int zl = a.length / 2;
        while (zl >= 1) {
            //进行一次带增量的直接插入排序.
            shellInsertSort(a, zl);
            //增量减半.
            zl = zl / 2;
        }
    }

    /**
     * 2020/3/7 21:08
     * 类似直接插入排序,只是插入排序的增量是1,这里增量是dk.
     * 所以可以说希尔排序里面包含了直接插入排序.
     *
     * zl:增量.
     */
    private void shellInsertSort(int[] a, int zl) {
        //i 是第一个间隔的末位置. 一直循环到最后,遍历完这个数组.
        for (int i = zl; i < a.length; i++) {
            //i-zl是这一个间隔的初始位置.即后面比前面小, 不满足从小到大排序.开始转换.
            if (a[i] < a[i - zl]) {
                int first;
                //x是间隔末位置元素. 是待插入的元素.
                int last = a[i];
                //j 是该间隔的初始位置.   往前倒腾间隔,直到<0或者遇到合适的排序顺序.
                //循环条件是,间隔末位置元素小于间隔初始位置.即后面比前面小.
                //for循环 循环的是一组,该组中元素都间隔dk.
                //这里不是互换位置,而是反复把短间隔的初始值付给了末尾,最后跳出循环之后,将一开始保存的a[i] 赋值给最后一次赋值的端间隔的初始值.意思是将a[i]放到了尽可能合适的位置.
                //最后一次成功进入循环体的first位置,就是待插入元素应该在的位置.
                for ( first = i - zl; first >= 0 && last < a[first]; first = first - zl) {
                    //当初始位置>=0,且初始位置比末尾大时,把初始值赋值给末尾值.
                    a[first + zl] = a[first];
                }
                //因为最后一次循环,first=first-zl 所以,first+zl
                //insert
                a[first+zl]=last;
            }
        }
    }

    private void print(int a[]){
        for (int x : a) {
            System.out.println(x + " ");
        }
    }

}
