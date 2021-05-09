package com.leetCode;

/**
 * 나의 solution :
 * 우선 한번 순회를 통해 A, B의 길이와 각 끝점이 만나는지를 확인한다.
 * 만나지 않으면 둘의 intersection은 없기 때문에 None을 반환한다.
 * 그리고 길이가 긴쪽의 포인터를 차이만큼 움직여서 같은 길이에서 탐색을 시작해서 같은 점을 발견하면 그점이 intersection!
 * 리스트 두 개가 주어졌을 때 두 리스트의 겹치는 부분의 HeadNode 를 리턴하는 문제입니다.
 */

class ListNodeList {
    int val;
    ListNodeList next;
    ListNodeList(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionOfTwoLinkedLists {

    public ListNodeList getIntersectionNode(ListNodeList headA, ListNodeList headB) {
        if(headA == null || headB == null) return null;

        ListNodeList a_pointer = headA;
        ListNodeList b_pointer = headB;

        while(a_pointer != b_pointer){
            a_pointer = a_pointer == null? headB : a_pointer.next;
            b_pointer = b_pointer == null? headA : b_pointer.next;
        }

        return a_pointer;
    }

    public static void main(String[] args) {
        int intersectVal = 8;
        int[] listA = {4,1,8,4,5};
        int[] listB = {5,6,1,8,4,5};
        int skipA = 2;
        int skipB = 3;

        ListNodeList rootA = new ListNodeList(4);
        rootA.next = new ListNodeList(1);
        rootA.next.next = new ListNodeList(8);
        rootA.next.next.next = new ListNodeList(4);
        rootA.next.next.next.next = new ListNodeList(5);

        ListNodeList rootB = new ListNodeList(5);
        rootB.next = new ListNodeList(6);
        rootB.next.next = new ListNodeList(1);
        rootB.next.next.next = new ListNodeList(8);
        rootB.next.next.next.next = new ListNodeList(4);
        rootB.next.next.next.next.next = new ListNodeList(5);

        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(rootA, rootB));
    }
}
