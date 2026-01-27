package dev.a110.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RemoveNthNodeFromEndOfListTest {
  private RemoveNthNodeFromEndOfList.ListNode parseList(String input) {
    if (input.isEmpty()) {
      return null;
    }
    String[] nodes = input.split(",");
    RemoveNthNodeFromEndOfList.ListNode dummy = new RemoveNthNodeFromEndOfList.ListNode(0);
    RemoveNthNodeFromEndOfList.ListNode current = dummy;
    for (String node : nodes) {
      current.next = new RemoveNthNodeFromEndOfList.ListNode(Integer.parseInt(node));
      current = current.next;
    }
    return dummy.next;
  }

  @ParameterizedTest
  @CsvSource({
      "'1,2,3,4,5', 2, '1,2,3,5'",
      "'1', 1, ''",
      "'1,2', 1, '1'"
  })
  void testRemoveNthNodeFromEndOfListMultiple(String listInput, int n, String expectedResultInput) {
    RemoveNthNodeFromEndOfList.ListNode list = parseList(listInput);
    RemoveNthNodeFromEndOfList.ListNode expectedResult = parseList(expectedResultInput);

    RemoveNthNodeFromEndOfList solver = new RemoveNthNodeFromEndOfList();
    RemoveNthNodeFromEndOfList.ListNode result = solver.removeNthFromEnd(list, n);

    Assertions.assertEquals(expectedResult, result);
  }
}
