package org.henry;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ListNode listNode1 = Helper.createListNode(new int[]{4, 1});
        ListNode listNode2 = Helper.createListNode(new int[]{5, 6, 1});
        ListNode intersectionListNode = Helper.createListNode(new int[]{8, 3, 4, 5});

        ListNode current = listNode1;
        while (current != null) {
            if (current.next == null) {
                listNode1.next = intersectionListNode;
                break;
            }
            current = current.next;
        }

        current = listNode2;
        while (current != null) {
            if (current.next == null) {
                listNode2.next = intersectionListNode;
                break;
            }
            current = current.next;
        }

        ListNode result1 = Solution.getIntersectionNode1(listNode1, listNode2);
        ListNode result2 = Solution.getIntersectionNode2(listNode1, listNode2);

        System.out.println("Result: " + result1.val + ", Reference: " + result1);
        System.out.print("Result: " + result2.val + ", Reference: " + result1);
    }
}

/*
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.

 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns.
 * Custom Judge:
 * The inputs to the judge are given as follows (your program is not given these inputs):

 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.

 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program.
 * If you correctly return the intersected node, then your solution will be accepted.

 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B)
 * are different node references. In other words, they point to two different locations in memory, while the nodes with value 8
 * in A and B (3rd node in A and 4th node in B) point to the same location in memory.
 */
class Solution {
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode currentA = headA;
        while (currentA != null) {
            set.add(currentA);
            currentA = currentA.next;
        }

        ListNode currentB = headB;
        while (currentB != null) {
            if (set.contains(currentB)) return currentB;
            currentB = currentB.next;
        }

        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode currentA = headA;

        while (currentA != null) {
            ListNode currentB = headB;

            while (currentB != null) {
                if (currentA.equals(currentB)) return currentA;
                currentB = currentB.next;
            }

            currentA = currentA.next;
        }

        return null;
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