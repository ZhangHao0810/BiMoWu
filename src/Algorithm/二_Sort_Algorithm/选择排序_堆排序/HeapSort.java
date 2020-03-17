package Algorithm.二_Sort_Algorithm.选择排序_堆排序;

/**
 * @author ZhangHao
 * @date 2020/3/10 17:50
 * @Description： 选择排序_堆排序
 *   二叉树有一个非常牛逼的性质,就是 父亲的两倍就是他的左孩子,再+1 就是右孩子.(int)孩子/2 就是父亲.
 *   要注意,一般二叉树放在一位数组中,数组的索引是从0开始. 所以 任意父节点: (i-1)/2 孩子节点:  2*i+1 左, 2*i +2 右.
 *
 * <p>
 * 有两个过程 1.建立堆,2.堆顶与堆的最后一个元素交换位置.
 * 一定一定要注意,堆排序的意义只是父亲比孩子大, 根是堆的最大值. 一个堆不一定是排好序的,想要达到排序的功能,需要多次创建堆, 就像冒泡排序需要多次冒泡一样.
 *
 * 所以,想要用堆这种结构来达到对数组排序的功能,需要将位于堆顶的元素放到最后的存储位置,然后忽略最后的存储位置,对剩余的再进行堆排序,递归. 最后就能形成有顺序的结构了.
 *
 *
 * 它的最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
//        int[] a = {3, 1, 5, 7};
        HeapSort obj = new HeapSort();
        System.out.println("初始值:");
        obj.print(a);
        System.out.println("-------------");

        for (int i = 0; i < a.length; i++) {
//            一个一个的将数组元素创建小顶堆
            obj.createLittleHeap(a, a.length - 1 - i);
            System.out.println("#######");
            obj.print(a);
            System.out.println();
//            每次循环完,二叉树的根节点都是最小值
//            将根节点放置在最后的位置. 即小顶堆的顶部放到了最后元素,最后输出就是从大到小.
            obj.swap(a, 0, a.length - 1 - i);
//
            obj.print(a);
            System.out.println("#######");
            System.out.println();
        }
        System.out.println("\n排序后:");
        obj.print(a);
    }

    /**
     * 2020/3/10 18:14
     * 创建小顶堆.
     * 双亲节点小于子节点的值.从叶子节点开始,直到根节点.
     * <p>
     * last : 合理树的最后一个元素.
     *
     *   一定要记住, 堆排序不是建立一个堆,内部的数组就是排好序了, 只不过满足父亲比两个孩子小/大,其他都不保证,
     *    所以每次创建堆,能得到小顶或者大顶堆, 确定堆顶的元素是所有元素的最小或者最大值.  就像冒泡排序一样.
     */
    private void createLittleHeap(int[] data, int last) {
//        从last的双亲倒着遍历到根节点.
        for (int i = (last - 1) / 2; i >= 0; i--) {
//            保存当前节点作为双亲节点,这个双亲在下面会进行迭代.
            int parent = i;
//             若双亲的左子节点存在,进入while
            while (2 * parent + 1 <= last) {
//            bigger 总是记录 值 较大的点的索引,先赋值为当前判断节点的左子节点
                //bigger 指向了 左子节点.
                int bigger = 2 * parent + 1;
                //如果左子节点索引比最后小,说明存在右子节点
                if (bigger < last) {
                    //右子节点<左子节点时
                    if (data[bigger] > data[bigger+1]) {
                        bigger++;
                    }
                }
                if (data[parent] > data[bigger]) {
                    //若双亲节点值大于子节点中最大的,交换两者,让父节点成为小的那个.
                    swap(data, parent, bigger);
                    parent = bigger;
                } else {
                    break;
                }
            }
        }
    }

    public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }

    public void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
//      用这种方法,阔以减少空间复杂度. 不用temp了.
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }




}
