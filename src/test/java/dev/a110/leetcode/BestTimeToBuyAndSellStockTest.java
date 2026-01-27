package dev.a110.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Arrays;

public class BestTimeToBuyAndSellStockTest {
  @ParameterizedTest
  @CsvSource({
      "'7,1,5,3,6,4', 5",
      "'7,6,4,3,1', 0"
  })
  void testBestTimeToBuyAndSellStockMultiple(String input, int expectedProfit) {
    int[] nums = Arrays.stream(input.split(","))
        .mapToInt(Integer::parseInt)
        .toArray();

    BestTimeToBuyAndSellStock solver = new BestTimeToBuyAndSellStock();
    int res = solver.maxProfit(nums);

    Assertions.assertEquals(expectedProfit, res);
  }
}
