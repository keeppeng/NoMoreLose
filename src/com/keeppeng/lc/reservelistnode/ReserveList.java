package com.keeppeng.lc.reservelistnode;

import java.util.Iterator;
import java.util.List;

/**
 * 链表反转
 */
public class ReserveList {

    public static void main(String[] args) {
        ListNode listNode = initListNode();
        printListNode(listNode);
        System.out.println("start reserve ... ");
//        ListNode reverseList = reverseList(listNode);
        ListNode reverseList = reverseListByDG(listNode);

        printListNode(reverseList);
    }

    /**
     * 使用递归来做
     * @param listNode
     * @return
     */
    private static ListNode reverseListByDG(ListNode listNode) {
        if (null == listNode || null == listNode.next) {
            return listNode;
        }
        ListNode newList = reverseListByDG(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        // 我理解递归的话应该是一个反向的操作,也就是从最后一个节点慢慢往前去搞; 有next 则 先搞next
        // next == null 表示是最后一个节点
        return newList;
    }

    private static void printListNode(ListNode listNode) {
        while (true) {
            System.out.println(listNode.val);
            listNode = listNode.next;
            if (null == listNode) {
                break;
            }
        }
    }

    /**
     * 常规循环方法做链表反转
     * @param listNode
     * @return
     */
    private static ListNode reverseList(ListNode listNode) {
        if (null == listNode) {
            return null;
        }
        ListNode pre = null;
        ListNode next;

        while (true) {
            // 1后续节点存储起来
            next = listNode.next;
            // 2当前节点的下一个指向之前的链表(第一个则为空)
            listNode.next = pre;
            // 3将当前反转的这个节点存储
            pre = listNode;
            // 4继续反转后面的节点
            listNode = next;
            if (next == null) {
                break;
            }
        }

        return pre;
    }

    private static ListNode initListNode() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(5, node4);
        return node5;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
