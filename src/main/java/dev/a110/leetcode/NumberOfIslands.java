package dev.a110.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
  private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

  private void explore(char[][] grid, int row, int col) {
    if (row < 0 || row >= grid.length ||
        col < 0 || col >= grid[0].length ||
        grid[row][col] != '1') {
      return;
    }

    grid[row][col] = '2';
    for (int[] dir : DIRS) {
      explore(grid, row + dir[0], col + dir[1]);
    }
  }

  public int numIslandsDfs(char[][] grid) {
    int result = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == '1') {
          result++;
          explore(grid, row, col);
        }
      }
    }
    return result;
  }

  public int numIslandsBfs(char[][] grid) {
    int result = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    Queue<int[]> neighbors = new ArrayDeque<>();

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == '1') {
          result++;
          grid[r][c] = '2';
          neighbors.offer(new int[] { r, c });

          while (!neighbors.isEmpty()) {
            int[] neighbor = neighbors.poll();
            int nr = neighbor[0];
            int nc = neighbor[1];

            for (int[] dir : DIRS) {
              int nnr = nr + dir[0];
              int nnc = nc + dir[1];
              if (nnr >= 0 && nnr < rows &&
                  nnc >= 0 && nnc < cols &&
                  grid[nnr][nnc] == '1') {
                grid[nnr][nnc] = '2';
                neighbors.offer(new int[] { nnr, nnc });
              }
            }
          }
        }
      }
    }

    return result;
  }
}
