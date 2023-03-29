// https://leetcode.com/problems/flood-fill

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/flood-fill
public class FloodFill {

    public static void main(String... args) {

        int[][] r = floodFill(new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}}, 1, 1, 2);

        List.of(r).stream().forEach((x) -> System.out.println(Arrays.toString(x)));

        r = floodFill(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
        }, 0, 0, 0);

        List.of(r).stream().forEach((x) -> System.out.println(Arrays.toString(x)));
    }


    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        HashSet<String> processed = new HashSet<String>();
        LinkedList<Integer> row = new LinkedList<>();
        LinkedList<Integer> col = new LinkedList<>();

        int r = sr;
        int c = sc;
        String p = r + "," + c;

        row.add(r);
        col.add(c);
        processed.add(p);

        while (!row.isEmpty()) {
            r = row.pollFirst();
            c = col.pollFirst();

            if (r - 1 >= 0) {
                if (image[r - 1][c] == image[r][c]) {
                    p = (r - 1) + "," + c;
                    if (!processed.contains(p)) {
                        row.add(r - 1);
                        col.add(c);
                        processed.add(p);
                    }
                }
            }

            if (r + 1 < image.length) {
                if (image[r + 1][c] == image[r][c]) {
                    p = (r + 1) + "," + c;
                    if (!processed.contains(p)) {
                        row.add(r + 1);
                        col.add(c);
                        processed.add(p);
                    }
                }
            }

            if (c - 1 >= 0) {
                if (image[r][c - 1] == image[r][c]) {
                    p = r + "," + (c - 1);
                    if (!processed.contains(p)) {
                        row.add(r);
                        col.add(c - 1);
                        processed.add(p);
                    }
                }
            }

            if (c + 1 < image[r].length) {
                if (image[r][c + 1] == image[r][c]) {
                    p = r + "," + (c + 1);
                    if (!processed.contains(p)) {
                        row.add(r);
                        col.add(c + 1);
                        processed.add(p);
                    }
                }
            }

            image[r][c] = color;
        }
        return image;
    }
}
