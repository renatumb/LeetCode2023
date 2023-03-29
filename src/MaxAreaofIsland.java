// https://leetcode.com/problems/max-area-of-island/

import java.util.HashSet;
import java.util.LinkedList;

public class MaxAreaofIsland {

    public static void main(String... args) {

        System.out.println(maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        HashSet<String> visited = new HashSet<String>();
        String v;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                v = i + "," + j;
                if (grid[i][j] == 1 && !visited.contains(v)) {
                    visited.add(v);
                    LinkedList<Integer> r = new LinkedList<Integer>();
                    LinkedList<Integer> c = new LinkedList<Integer>();

                    r.add(i);
                    c.add(j);
                    int size = 0;
                    int row;
                    int col;

                    while (!r.isEmpty()) {
                        size++;
                        row = r.pollFirst();
                        col = c.pollFirst();

                        if (row - 1 >= 0 && grid[row - 1][col] == 1 && !visited.contains((row - 1) + "," + col)) {
                            r.add(row - 1);
                            c.add(col);
                            visited.add((row - 1) + "," + col);
                        }
                        if (row + 1 < grid.length && grid[row + 1][col] == 1 && !visited.contains((row + 1) + "," + col)) {
                            r.add(row + 1);
                            c.add(col);
                            visited.add((row + 1) + "," + col);
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == 1 && !visited.contains(row + "," + (col - 1))) {
                            r.add(row);
                            c.add(col - 1);
                            visited.add(row + "," + (col - 1));
                        }
                        if (col + 1 < grid[row].length && grid[row][col + 1] == 1 && !visited.contains(row + "," + (col + 1))) {
                            r.add(row);
                            c.add(col + 1);
                            visited.add(row + "," + (col + 1));
                        }

                    }
                    max = max > size ? max : size;
                }
            }
        }
        return max;
    }
}
