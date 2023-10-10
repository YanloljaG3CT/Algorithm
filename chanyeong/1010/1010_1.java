import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    static String A, B, answer;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        answer = br.readLine();
    }

    private static void solution() {
        int[] table = makeTable(answer);
        if (kmp(A, answer, table) && kmp(B, answer, table)) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }

    static int[] makeTable(String pattern) {
        int[] table = new int[pattern.length()];
        int index = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (index > 0 && pattern.charAt(i) != pattern.charAt(index)) {
                index = table[index - 1];
            }

            if (pattern.charAt(index) == pattern.charAt(i)) {
                table[i] = ++index;
            }
        }

        return table;
    }


    public static boolean kmp(String parent, String pattern, int[] table) {
        int index = 0;
        for (int i = 0; i < parent.length(); i++) {
            while (index > 0 && parent.charAt(i) != pattern.charAt(index)) {
                index = table[index - 1];
            }
            if (parent.charAt(i) == pattern.charAt(index)) {
                if (index == pattern.length() - 1) {
                    return true;
                } else {
                    index++;
                }
            }
        }
        return false;
    }
}
