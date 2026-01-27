package dev.a110.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      int complement = target - num;

      Integer complementIndex = map.get(complement);
      if (complementIndex != null) {
        return new int[] { complementIndex, i };
      }

      map.put(num, i);
    }

    return new int[] {};
  }
}
