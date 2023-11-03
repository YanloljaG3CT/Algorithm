import java.io.*;

//스페셜 저지
public class bj9253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        String answer = br.readLine();
        int[] table = makeTable(answer);

        String result = "NO";
        if (KMP(A, answer, table) && KMP(B, answer, table)) {
            result = "YES";
        }
        System.out.println(result);
    }

    static int[] makeTable(String str) {
        int[] table = new int[str.length()];
        int idx = 0;
        for (int i = 1; i < table.length; i++) {
            while (idx > 0 && str.charAt(i) != str.charAt(idx)) {
                idx = table[idx - 1];
            }

            if (str.charAt(idx) == str.charAt(i)) {
                table[i] = ++idx;
            }
        }
        return table;
    }

    static boolean KMP (String parent, String target, int[] table) {
        int idx = 0;
        for (int i = 0; i < parent.length(); i++) {
            while (idx > 0 && parent.charAt(i) != target.charAt(idx)){
                idx = table[idx - 1];
            }
            if (parent.charAt(i) == target.charAt(idx)) {
                if (idx == target.length()-1) {
                    return true;
                } else {
                    idx++;
                }
            }
        }
        return false;
    }
}
