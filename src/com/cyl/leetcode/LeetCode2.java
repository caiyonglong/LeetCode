package com.cyl.leetcode;

import org.w3c.dom.NodeList;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode2 {

    ListNode l1, l2;

    /**
     * 初始化输入参数
     */
    public LeetCode2() {
        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
    }

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;//= new ListNode((l1.val + l2.val) % 10);
        int num = 0;// (l1.val + l2.val) / 10;
        while (l1 != null || l2 != null) {
            int a = 0, b = 0;
            //非空判断
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            //非空判断
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int val = a + b + num;
            System.out.println(val + " ---- " + a + "--" + b + "= " + num);
            ListNode tmp = new ListNode(val % 10);
            tmp.next = l3;
            l3 = tmp;
            printListNode(l3);
            num = val / 10;
        }
        if (num != 0) {
            ListNode tmp = new ListNode(1);
            tmp.next = l3;
            l3 = tmp;
        }
        return reverseList(l3);
    }

    /**
     * 反转单链表
     *
     * @param node
     * @return
     */
    public ListNode reverseList(ListNode node) {
        ListNode preNode = null;
        ListNode cur = node;
        ListNode nextNode = null;
        while (cur != null) {
            nextNode = cur.next; //获取当前链表
            cur.next = preNode; //获取当前链表
            preNode = cur; // 上一节点等于当前链表节点（next = null）
            cur = nextNode; // node位移到上一节点
        }
        return preNode;
    }

    /**
     * 打印节点
     *
     * @param l
     */
    public void printListNode(ListNode l) {
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
        System.out.println();
    }
}
