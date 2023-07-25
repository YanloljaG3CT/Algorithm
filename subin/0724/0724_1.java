import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        // 총 학생 수
        int N = Integer.parseInt(st.nextToken());
        // 조는 학생 수
        int K = Integer.parseInt(st.nextToken());
        // 출석 코드 보낼 학생 수
        int Q = Integer.parseInt(st.nextToken());
        // 구간 개수
        int M = Integer.parseInt(st.nextToken());

        int[] totalStudent = new int[N + 3];

        // 모든 학생을 1로 초기화
        for (int i = 3; i < N + 3; i++) {
            totalStudent[i] = 1;
        }

        // 자는 학생은 sleepingStudent = true
        boolean[] sleepingStudent = new boolean[N + 3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int entryNumber = Integer.parseInt(st.nextToken());
            sleepingStudent[entryNumber] = true;
        }

        // 코드 받은 학생 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int codeStudent = Integer.parseInt(st.nextToken());
            // 코드 받은 학생이 자는 학생인 경우
            if (sleepingStudent[codeStudent]) {
                continue;
            }
            // 자는 학생이 아니면 배수 확인
            for (int j = codeStudent; j < N + 3; j += codeStudent) {
                if (!sleepingStudent[j]) {
                    totalStudent[j] = 0;
                }
            }
        }

        // 부분 합
        for (int i = 4; i < N + 3; i++) {
            totalStudent[i] += totalStudent[i - 1];
        }

        // 구간 내에서 출석 못 한 학생 구하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(totalStudent[end]-totalStudent[start-1]);
        }
    }
}
