package dev.a110.leetcode;

import java.util.HashSet;

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    var set = new HashSet<Integer>();

    for (int num : nums) {
      if (!set.add(num)) {
        return true;
      }
    }

    return false;
  }
}
