package dev.a110.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberOfIslandsTest {
  private char[][] parseGrid(String input) {
    String content = input.substring(2, input.length() - 2);
    String[] rows = content.split("\\],\\[");
    char[][] grid = new char[rows.length][];
    for (int i = 0; i < rows.length; i++) {
      String[] cols = rows[i].split(",");
      grid[i] = new char[cols.length];
      for (int j = 0; j < cols.length; j++) {
        grid[i][j] = cols[j].trim().charAt(0);
      }
    }
    return grid;
  }

  @ParameterizedTest
  @CsvSource({
      "'[[1,1,1,1,0],[1,1,0,1,0],[1,1,0,0,0],[0,0,0,0,0]]', 1",
      "'[[1,1,0,0,0],[1,1,0,0,0],[0,0,1,0,0],[0,0,0,1,1]]', 3"
  })
  void testNumberOfIslandsMultiple(String input, int expectedResult) {
    NumberOfIslands solver = new NumberOfIslands();

    int resultDfs = solver.numIslandsDfs(parseGrid(input));
    Assertions.assertEquals(expectedResult, resultDfs, "DFS: Number of islands should match expected");

    int resultBfs = solver.numIslandsBfs(parseGrid(input));
    Assertions.assertEquals(expectedResult, resultBfs, "BFS: Number of islands should match expected");
  }
}
