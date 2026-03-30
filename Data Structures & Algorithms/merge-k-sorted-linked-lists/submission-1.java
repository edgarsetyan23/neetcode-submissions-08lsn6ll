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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        // Create a min-heap priority queue
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the first node of each list to the queue
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (!queue.isEmpty()) {  // Fixed: Changed isNotEmpty() to isEmpty()
            ListNode smallest = queue.poll();
            tail.next = smallest;
            tail = tail.next;
            
            if (smallest.next != null) {
                queue.add(smallest.next);
            }
        }
        
        return dummy.next;
    }
}