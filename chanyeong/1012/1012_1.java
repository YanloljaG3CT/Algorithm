import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String S, K;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        K = br.readLine();
    }

    private static void solution() {
        int[] table = makeTable();
        if (kmp(table)) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    static boolean kmp(int[] table) {
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            if (!Character.isAlphabetic(S.charAt(i))) {
                continue;
            }

            while (index > 0 && S.charAt(i) != K.charAt(index)) {
                index = table[index - 1];
            }

            if (S.charAt(i) == K.charAt(index)) {
                if (index == K.length() - 1) {
                    return true;
                }
                index++;
            }
        }
        return false;
    }

    static int[] makeTable() {
        int[] table = new int[K.length()];
        int index = 0;
        for (int i = 1; i < K.length(); i++) {
            while (index > 0 && K.charAt(i) != K.charAt(index)) {
                index = table[index - 1];
            }

            if (K.charAt(i) == K.charAt(index)) {
                table[i] = ++index;
            }
        }
        return table;
    }
}
