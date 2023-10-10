import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9253 {
    public static String pattern;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        pattern = br.readLine();

        if (isPatternMatch(a) && isPatternMatch(b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean isPatternMatch(String text) {
        int[] pi = calculatePi();

        int j = 0; // pattern 인덱스
        for (int i = 0; i < text.length(); i++) { // text 인덱스
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) { // 패턴 일치 확인
                    return true;
                } else {
                    j++;
                }
            }

        }

        return false;
    }

    public static int[] calculatePi() {
        int[] pi= new int[pattern.length()];

        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = pi[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)){
                pi[i] = ++j;
            }

        }

        return pi;
    }

}