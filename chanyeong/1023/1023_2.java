import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] nums;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sr.nextInt();
        }
    }

    private static void solution() {
        StringBuilder sb = new StringBuilder();

        mergeSort(nums, 0, N - 1);

        Arrays.stream(nums)
                .forEach(num -> sb.append(num).append('\n'));
        System.out.println(sb);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            int leftSize = middle - left + 1;
            int[] leftArray = new int[leftSize];
            for (int i = 0; i < leftSize; i++) {
                leftArray[i] = arr[left + i];
            }

            int rightSize = right - middle;
            int[] rightArray = new int[rightSize];
            for (int i = 0; i < rightSize; i++) {
                rightArray[i] = arr[middle + 1 + i];
            }

            int i = 0, j = 0;
            int k = left;

            while (i < leftSize && j < rightSize) {
                if (leftArray[i] <= rightArray[j]) {
                    arr[k] = leftArray[i++];
                } else {
                    arr[k] = rightArray[j++];
                }
                k++;
            }

            while (i < leftSize) {
                arr[k++] = leftArray[i++];
            }
            while (j < rightSize) {
                arr[k++] = rightArray[j++];
            }
        }
    }

    static class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(readLine());
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
