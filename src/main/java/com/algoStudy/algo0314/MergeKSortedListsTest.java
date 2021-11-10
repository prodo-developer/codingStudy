package com.algoStudy.algo0314;

import java.util.PriorityQueue;

public class MergeKSortedListsTest {

    private static class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        ListNode newHead = new ListNode(0); // dummy Data
        ListNode p = newHead;

        for (ListNode node : lists) {
            if(node != null) {
                queue.offer(node);
            }
        }

        //2
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if(node.next != null) {
                queue.offer(node.next);
            }
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = n1;
        list[1] = n2;
        list[2] = n3;

        ListNode node = new MergeKSortedListsTest().mergeKLists(list);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
