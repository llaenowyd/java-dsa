package dev.a110.leetcode;

public class RemoveNthNodeFromEndOfList {
  static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      ListNode other = (ListNode) obj;
      return val == other.val &&
          ((next == null && other.next == null) ||
              (next != null && next.equals(other.next)));
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode left = dummy;
    ListNode right = head;

    while (n > 0 && right != null) {
      right = right.next;
      n--;
    }

    while (right != null) {
      left = left.next;
      right = right.next;
    }

    left.next = left.next.next;

    return dummy.next;
  }
}
