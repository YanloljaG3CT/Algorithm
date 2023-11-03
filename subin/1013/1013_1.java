import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//듣보잡
public class bj1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if(set.contains(tmp)){
                result.add(tmp);
            }
        }

        Collections.sort(result);

        // print result
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
