/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        boolean flag = false;
        ListNode pos1 = head;
        ListNode pos2 = head;
        while(pos2 != null){
            pos1 = pos1.next;
            pos2 = pos2.next;
            if(pos2 != null){
                pos2 = pos2.next;
                if(pos2 == pos1){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}