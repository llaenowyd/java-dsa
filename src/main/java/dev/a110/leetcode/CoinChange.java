package dev.a110.leetcode;

import java.util.Arrays;

public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    int[] table = new int[amount + 1];
    Arrays.fill(table, amount + 1);
    table[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i - coin >= 0) {
          table[i] = Math.min(table[i], 1 + table[i - coin]);
        }
      }
    }
    return table[amount] < amount + 1 ? table[amount] : -1;
  }
}
