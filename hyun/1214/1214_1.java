class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int lux = 0, luy = 0;
        int rdx = wallpaper.length, rdy = wallpaper[0].length();

        outer: for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    answer[0] = lux;
                    break outer;
                } else if (j + 1 == wallpaper[i].length()) {
                    lux++;
                }
            }
        }

        outer: for (int i = 0; i < wallpaper[0].length(); i++) {
            for (int j = 0; j < wallpaper.length; j++) {
                if (wallpaper[j].charAt(i) == '#') {
                    answer[1] = luy;
                    break outer;
                } else if (j + 1 == wallpaper.length) {
                    luy++;
                }
            }
        }

        outer: for (int i = wallpaper.length - 1; i >= 0; i--) {
            for (int j = wallpaper[i].length() - 1; j >= 0; j--) {
                if (wallpaper[i].charAt(j) == '#') {
                    answer[2] = rdx;
                    break outer;
                } else if (j == 0) {
                    rdx--;
                }
            }
        }

        outer: for (int i = wallpaper[0].length() - 1; i >= 0; i--) {
            for (int j = wallpaper.length - 1; j >= 0; j--) {
                if (wallpaper[j].charAt(i) == '#') {
                    answer[3] = rdy;
                    break outer;
                } else if (j == 0) {
                    rdy--;
                }
            }
        }

        return answer;
    }
}