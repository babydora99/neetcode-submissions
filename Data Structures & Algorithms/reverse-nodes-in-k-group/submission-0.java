/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//Iterative Reversal
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode groupPrev=dummy;

        while(true){
            //find kth node
            ListNode kth=getKthNode(groupPrev,k);

            //fewer than k nodes remain
            if(kth==null){
                break;
            }
            //Node after current group
            ListNode groupNext=kth.next;

            //Reverse the current group
            ListNode prev=groupNext;
            ListNode curr=groupPrev.next;

            while(curr!=groupNext){
                ListNode next=curr.next;

                curr.next=prev;
                prev=curr;
                curr=next;
            }
            //Connect the reversed group
            ListNode temp=groupPrev.next;
            groupPrev.next=kth;

            //Move to the next group
            groupPrev=temp;
        }
        return dummy.next;
    }
    private ListNode getKthNode(ListNode curr,int k){
        while(curr!=null && k>0){
            curr=curr.next;
            k--;
        }
        return curr;
    }
}
