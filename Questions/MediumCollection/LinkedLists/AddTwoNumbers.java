package org.henry;

public class Main {
    public static void main(String[] args) {
        ListNode listNode1 = Helper.createListNode(new int[]{2, 4, 3});
        ListNode listNode2 = Helper.createListNode(new int[]{5, 6, 4});

        ListNode result = Solution.addTwoNumbers(listNode1, listNode2);
        System.out.print(Helper.listNodeToString(result));
    }
}

/*
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.

 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int sum = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(sum % 10);
            current = current.next;
            sum /= 10;
        }

        if (sum != 0) current.next = new ListNode(sum);
        return result.next;
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