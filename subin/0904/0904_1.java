package fc0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class camping {
    public static int L,P,V,period;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int i=1;
        while (true){
            st=new StringTokenizer(br.readLine());
            L= Integer.parseInt(st.nextToken());
            P= Integer.parseInt(st.nextToken());
            V= Integer.parseInt(st.nextToken());
            if (L==0&&P==0&&V==0) break;
            sb.append("Case ").append(i).append(": ").append(count()).append("\n");
            i++;
        }
        System.out.print(sb);
    }

    public static int count() {
        period=L*(V/P)+Math.min(L,(V%P));
        return period;
    }
}
