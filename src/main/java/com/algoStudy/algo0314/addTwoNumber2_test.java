package com.algoStudy.algo0314;

import java.util.Stack;

public class addTwoNumber2_test {

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
    public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode head = null;
        while(!stack1.isEmpty()||!stack2.isEmpty()||carry>0){
            int sum=carry;
            sum+=stack1.isEmpty()?0:stack1.pop();
            sum+=stack2.isEmpty()?0:stack2.pop();
            ListNode node = new ListNode(sum%10);
            node.next = head;
            head = node;
            carry=sum/10;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(4);
        n1.next.next.next = new ListNode(3);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);

        ListNode node = new addTwoNumber2_test().addTwoNumbers(n1, n2);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
