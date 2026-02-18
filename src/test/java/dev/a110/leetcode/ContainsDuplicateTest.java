package dev.a110.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ContainsDuplicateTest {
  @ParameterizedTest
  @CsvSource({
      "'1,2,3,1', true",
      "'1,2,3,4', false",
      "'1,1,1,3,3,4,3,2,4,2', true"
  })
  void testContainsDuplicateMultiple(String input, boolean expected) {
    int[] nums = java.util.Arrays.stream(input.split(","))
        .mapToInt(Integer::parseInt)
        .toArray();

    ContainsDuplicate solver = new ContainsDuplicate();
    boolean res = solver.containsDuplicate(nums);

    Assertions.assertEquals(expected, res);
  }
}
