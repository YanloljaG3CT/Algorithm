package fc1214;

import java.util.*;

//바탕화면 정리
public class pg161990 {
    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        int[] answer = {};

        List<Pair> pairs = new ArrayList<>();

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    pairs.add(new Pair(j, i));
                    pairs.add(new Pair(j + 1, i + 1));

                    minX = Math.min(minX, j);
                    minY = Math.min(minY, i);
                    maxX = Math.max(maxX, j + 1);
                    maxY = Math.max(maxY, i + 1);
                }
            }
        }
        System.out.println(minY);
        System.out.println(minX);
        System.out.println(maxY);
        System.out.println(maxX);
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
