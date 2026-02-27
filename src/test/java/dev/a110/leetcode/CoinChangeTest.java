package dev.a110.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoinChangeTest {
  @ParameterizedTest
  @CsvSource({
      "'1,2,5', 11, 3",
      "'2', 3, -1",
      "'1', 0, 0"
  })
  void testCoinChange(String inputNums, int amount, int expected) {
    int[] nums = java.util.Arrays.stream(inputNums.split(","))
        .mapToInt(Integer::parseInt)
        .toArray();

    CoinChange solver = new CoinChange();
    int res = solver.coinChange(nums, amount);

    Assertions.assertEquals(expected, res);
  }
}
