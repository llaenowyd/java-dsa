package dev.a110.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindMedianFromDataStreamTest {
  @Test
  void testFindMedianFromDataStream() {
    FindMedianFromDataStream solver = new FindMedianFromDataStream();

    solver.addNum(1);
    solver.addNum(2);
    double res = solver.findMedian();
    Assertions.assertEquals(1.5, res, "Median after adding 1 and 2 should be 1.5");

    solver.addNum(3);
    res = solver.findMedian();
    Assertions.assertEquals(2, res, "Median after adding 3 should be 2");
  }
}
