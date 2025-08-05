/* You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order. */
import java.io.*;
import java.util.*;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class ListNodeSort {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if(list1.val<=list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1!=null) current.next = list1;
        if(list2!=null) current.next = list2;

        return dummy.next;
    }
    
    // Helper method to create a linked list from an array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    
    // Helper method to print a linked list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        ListNodeSort solution = new ListNodeSort();
        
        // Test case 1: list1 = [1,2,4], list2 = [1,3,4]
        System.out.println("Test case 1:");
        ListNode list1 = createList(new int[]{1, 2, 4});
        ListNode list2 = createList(new int[]{1, 3, 4});
        System.out.print("list1: ");
        printList(list1);
        System.out.print("list2: ");
        printList(list2);
        ListNode result1 = solution.mergeTwoLists(list1, list2);
        System.out.print("Merged: ");
        printList(result1);
        System.out.println();
        
        // Test case 2: list1 = [], list2 = []
        System.out.println("Test case 2:");
        ListNode list3 = createList(new int[]{});
        ListNode list4 = createList(new int[]{});
        System.out.print("list1: ");
        printList(list3);
        System.out.print("list2: ");
        printList(list4);
        ListNode result2 = solution.mergeTwoLists(list3, list4);
        System.out.print("Merged: ");
        printList(result2);
        System.out.println();
        
        // Test case 3: list1 = [], list2 = [0]
        System.out.println("Test case 3:");
        ListNode list5 = createList(new int[]{});
        ListNode list6 = createList(new int[]{0});
        System.out.print("list1: ");
        printList(list5);
        System.out.print("list2: ");
        printList(list6);
        ListNode result3 = solution.mergeTwoLists(list5, list6);
        System.out.print("Merged: ");
        printList(result3);
    }
}
