import java.util.*;

public class Greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N=sc.nextInt();
        int K=sc.nextInt();

        int[] coin = new int[N];
        int cnt=0;
        for(int i=0;i<N;i++){
            coin[i]=sc.nextInt();
        }

        for(int i=N-1;i>=0;i--){
            if(K>=coin[i]){
                cnt+=(K/coin[i]);
                K%=coin[i];
            }
        }
        System.out.println(cnt);
    }
}
