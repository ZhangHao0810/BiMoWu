package Algorithm.三_数组和链表;

/**
 * @author ZhangHao
 * @date 2020/3/17 22:47
 * @Description：
 * 题目描述
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 示例:
 * 1.	给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 * •	你的算法只能使用常数的额外空间。
 * •	你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class 将链表相邻的两个节点反转 {

    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int data) {
            this.value = data;
        }
    }

    /**
     * 2020/3/17 22:48
     * 循环法
     */
    public ListNode swapPairs(ListNode head) {
//        申请一个空的节点.
        ListNode tmp = new ListNode(0);
//        让链表的头结点指向空节点的下一个节点.
        tmp.next = head;

//        把空节点保留下来,用这个变量去完成交换
        ListNode temp=tmp;
        while(head != null && head.next !=null){
            temp.next = head.next;
            head.next = temp.next.next;
            temp.next.next = head;
            //当上面交换完了后，temp向后移两个节点。
            temp = temp.next.next;
            head = temp.next;
        }
        //返回空节点之后已经交换完了的链表
        return tmp.next;

    }
}
