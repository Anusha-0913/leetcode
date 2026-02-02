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
public ListNode reverseKGroup(ListNode head, int k) {
if (head == null || k == 1) return head;
ListNode dummy = new ListNode(0);
dummy.next = head;
ListNode prevGroup = dummy;
while (true) {
ListNode kth = prevGroup;
for (int i = 0; i < k && kth != null; i++) {
kth = kth.next;
}
if (kth == null) break;
ListNode groupStart = prevGroup.next;
ListNode prev = kth.next;
ListNode curr = groupStart;

for (int i = 0; i < k; i++) {
ListNode next = curr.next;
curr.next = prev;
prev = curr;
curr = next;
}
prevGroup.next = prev;
prevGroup = groupStart;
}
return dummy.next;
}
}
