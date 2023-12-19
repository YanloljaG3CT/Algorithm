package fc1218;

import java.util.Arrays;

//숫자 짝꿍
public class pg131128 {
    public static void main(String[] args) {

        String x = "100";
        String y = "2345";

        int[] arrX = new int[10];
        int[] arrY = new int[10];

        for (String s : x.split("")) {
            arrX[Integer.parseInt(s)]++;
        }
        for (String s : y.split("")) {
            arrY[Integer.parseInt(s)]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >=0 ; i++) {
            while (arrX[i] > 0 && arrY[i] > 0) {
                arrX[i]--;
                arrY[i]--;
            }
        }

        if(sb.toString().equals("")){
        }
        if(sb.toString().substring(0,1).equals("0")){
        }
    }
}
