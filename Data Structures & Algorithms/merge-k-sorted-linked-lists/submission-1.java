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
//Brute Force
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> values=new ArrayList<>();
        for(ListNode list:lists){
            while(list!=null){
                values.add(list.val);
                list=list.next;
            }
        }
        Collections.sort(values);

        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        
        for(int val:values){
            tail.next=new ListNode(val);
            tail=tail.next;
        }
        return dummy.next;
    }
}