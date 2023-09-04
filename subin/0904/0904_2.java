package fc0904;

import java.util.Scanner;

public class change {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int changeAmount=sc.nextInt();

        int coinCnt=0;

        while (changeAmount>0){
            if(changeAmount%5==0){
                coinCnt=changeAmount/5+coinCnt;
                break;
            }
            else {
                changeAmount-=2;
                coinCnt++;
            }
        }

        if(changeAmount<0){
            System.out.println(-1);
        }else {
            System.out.println(coinCnt);
        }


    }
}
