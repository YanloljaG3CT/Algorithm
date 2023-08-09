package fc0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quit {
    public static int[] T,P,maxMoney;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        T=new int[n];
        P=new int[n];
        maxMoney=new int[n+1];

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            T[i]= Integer.parseInt(st.nextToken());
            P[i]= Integer.parseInt(st.nextToken());
        }
        calMoney();
        System.out.println(maxMoney[n]);
    }

    public static void calMoney(){
        for(int i=0;i<n;i++){
            if(i+T[i]<=n){
                //maxMoney[i+T[i]]= 현재날짜+상담완료날짜 에 저장된 최대 수입, maxMoney[i]+P[i]=현재까지의 최대 수입+오늘 수입
                maxMoney[i+T[i]]=Math.max(maxMoney[i+T[i]], maxMoney[i]+P[i]);
            }
            //수입이 비는 요일을 고려, 해당 날짜에 일을 못할 때 이전까지 일한 최대 수당을 저장해놔야 한다.
            maxMoney[i+1]=Math.max(maxMoney[i+1],maxMoney[i]);
        }
    }
}
