package Algorithm.三_数组和链表;

/**
 * @author ZhangHao
 * @date 2020/3/17 16:46
 * @Description：
 */
public class 反转链表 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 2020/3/17 16:46
     * 递归法  从最后一个Node开始，在弹栈的过程中将指针顺序置换的
     * <p>
     * 递归实质上就是系统帮你压栈的过程，系统在压栈的时候会保留现场。
     * <p>
     * head 在递归过程当中,代表每一个节点.
     */
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
//        开始递归,一直递归到head为最后一个元素,head.next==null 返回最后一个元素给newHead;
        Node newHead = reverse(head.next);

//        temp 是原序列后一个,head是原序列前一个
//        这几句话就把指向颠倒了.第一次颠倒的是最后的两个节点.
        Node temp = head.next;
        temp.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 2020/3/17 18:24
     * 遍历法   在链表遍历的过程中将指针顺序置换.
     */
    public static Node reverseList(Node node) {
//  	准备两个空结点 pre用来保存先前结点、next用来做临时变量
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
//          走完上面两行之后,pre位于node前面一个节点.
        }
        return pre;
    }

}
