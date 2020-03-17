package Algorithm.三_数组和链表;

/**
 * @author ZhangHao
 * @date 2020/3/17 16:20
 * @Description： 递归实现斐波那契数列, 循环实现斐波那契数列.  fib[1]=fib[2]=1  fib[n]=fib[n-1]-fib[n-2];
 */
public class Feibo {

    /**
     * 2020/3/17 16:22
     * 递归方法. 效率较差.
     */
    public static int recFeiBo1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return recFeiBo1(n - 1) + recFeiBo1(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(recFeiBo1(6));
        System.out.println(recFeiBo2(6));
    }

    /**
     * 2020/3/17 16:25
     * 循环的方式实现Feibo. 时间复杂度 O(n)
     */
    public static int recFeiBo2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
//        从小到大推过来的. pre表示前一个,res表示后一个.temp暂存.
        int temp;
//        第一个数是1;
        int pre = 1;
//        第二个数也是1;
        int res = 1;

//        循环次数比n少两次,每循环一次,确定一个数.
//        暂存res,最后付给pre
        for (int i = 1; i < n - 2; i++) {
            temp = res;
//       fib[n]=fib[n-1]-fib[n-2];
//         res =   res  -  pre
            res += pre;
            pre = temp;
        }
        return res;
    }

}
