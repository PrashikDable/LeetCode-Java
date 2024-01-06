/*
141. Linked List Cycle

Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is 
used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}

/*

EXPLANATION:

*Initialize two pointers (slowPointer and fastPointer) at the head of the linked list.
*Use a while loop to traverse the linked list. The loop condition ensures that we don't encounter a null pointer and that the fastPointer has 
 a valid next pointer.
*Inside the loop, move the slowPointer one step at a time (slowPointer = slowPointer.next) and the fastPointer two steps at a 
 time (fastPointer = fastPointer.next.next).
*Check if the slowPointer is equal to the fastPointer. If they meet, it indicates the presence of a cycle in the linked list, and the 
 method returns true.
*If the loop completes without meeting pointers, it means there is no cycle in the linked list, and the method returns false.


*/