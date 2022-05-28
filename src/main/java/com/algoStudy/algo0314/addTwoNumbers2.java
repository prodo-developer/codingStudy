package com.algoStudy.algo0314;

// 노드로 접근해서 리버스로 치환하는 문제 (다르게 푼 문제)
public class addTwoNumbers2 {
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
    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode n1 = reverse(l1);
        ListNode n2 = reverse(l2);

        int carry = 0;
        ListNode temp = n1;
        ListNode pre = n1;

        System.out.println(temp.val + "====" + pre.val);
        while(n1!= null || n2 != null || carry != 0){
            int v1 = n1 == null? 0: n1.val;
            int v2 = n2 == null? 0: n2.val;
            if(n1 == null){
                n1 = new ListNode((v1+v2+carry) % 10);
                pre.next = n1;
            }else{
                n1.val = (v1+v2+carry) % 10;
            }
            carry = (v1+v2+carry)/10;
            pre = n1;
            n1 = n1 == null? null : n1.next;
            n2 = n2 == null? null : n2.next;
        }
        return reverse(temp);

    }

    private static ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(4);
        n1.next.next.next = new ListNode(3);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);

        ListNode node = solution(n1, n2);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
