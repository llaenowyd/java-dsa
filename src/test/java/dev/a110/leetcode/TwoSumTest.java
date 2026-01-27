package dev.a110.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Arrays;

public class TwoSumTest {
  @ParameterizedTest
  @CsvSource({
      "'2,7,11,15', 9",
      "'3,2,4', 6",
      "'3,3', 6"
  })
  void testTwoSumMultiple(String input, int target) {
    int[] nums = Arrays.stream(input.split(","))
        .mapToInt(Integer::parseInt)
        .toArray();

    TwoSum solver = new TwoSum();
    int[] res = solver.twoSum(nums, target);

    // Basic validations: two indices, indices distinct, within range, sum equals
    // target
    Assertions.assertNotNull(res, "result should not be null");
    Assertions.assertEquals(2, res.length, "result should contain exactly two indices");
    Assertions.assertTrue(res[0] >= 0 && res[0] < nums.length, "first index out of bounds");
    Assertions.assertTrue(res[1] >= 0 && res[1] < nums.length, "second index out of bounds");
    Assertions.assertNotEquals(res[0], res[1], "indices should be different");
    Assertions.assertEquals(target, nums[res[0]] + nums[res[1]], "numbers at indices must sum to target");
  }
}
