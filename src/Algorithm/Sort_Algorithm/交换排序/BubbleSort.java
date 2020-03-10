package Algorithm.Sort_Algorithm.交换排序;

/**
 * @author ZhangHao
 * @date 2020/3/10 22:32
 * @Description： 冒泡排序
 */
public class BubbleSort {

    /**
     * 2020/3/10 22:33
     * 传统的冒泡排序
     *
     * n是数组长度.
     */

    private void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1]=temp;

                }
            }

        }
    }

    /**
     * 2020/3/10 22:35
     * 改进了的冒泡排序,设置一个标识 exchenge, 标识这一趟是否有数据交换
     * 如果没有数据交换,说明已经排好序 便可以立即退出.
     *
     *  n是数组长度.
     *
     *  用while() 来判断 少用了一个if 很吊.
     *
     */
    private void bubble1(int r[], int n) {
        int i=n-1;
        while (i > 0) {
            int pos=0;
            for (int j = 0; j < i; j++) {
                if (r[j]>r[j+1]){
                    pos=j;
                    int temp = r[j]; r[j] = r[j+1]; r[j+1]=temp;
                }

                i=pos;
            }
        }
    }

    /**
     * 2020/3/10 22:40
     * 每趟找最大值和最小值, 将时间缩短到一半.
     */
    private void bubble2(int[] r, int n) {
        int low=0;
        int high=n-1;
        int tmp,j;
        while (low < high) {

            //正向冒泡,找最大值.
            for (j = low; j < high; j++) {
                if (r[j] > r[j + 1]) {
                    tmp = r[j]; r[j]=r[j+1];r[j+1]=tmp;
                }
            }
            high--;
            //反向冒泡,找最小值.
            for (j = high; j > low; j--) {
                if (r[j] < r[j - 1]) {
                    tmp = r[j]; r[j]=r[j-1];r[j-1]=tmp;
                }
            }
            low++;
        }

    }





}
