/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
       ListNode result = head;
      while(head != null && head.next != null){
        // while(head != null){
    	   ListNode next = head.next;
    	   if(head.val == next.val){
    		   head.next = next.next;
    	   }
    	   else{
    	       head = head.next;
    	   }
       }
       return result;
    }
}