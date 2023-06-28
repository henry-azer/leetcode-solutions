package org.henry;

public class Main {
    public static void main(String[] args) {
        ListNode listNode = Helper.createListNode(new int[]{1, 2, 3, 4, 5});

        ListNode result = Solution.oddEvenList(listNode);
        System.out.print(Helper.listNodeToString(result));
    }
}

/*
 * Given the head of a singly linked list, group all the nodes with odd indices together
 * followed by the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 */
class Solution {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


// Helper Class
class Helper {
    public static ListNode createListNode(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int value : values) {
            curr.next = new ListNode(value);
            curr = curr.next;
        }

        return dummy.next;
    }

    public static String listNodeToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}