import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//수 정렬하기5
public class bj15688 {
    public static int[] nums;
    public static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        tmp = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0,n-1);
        printArray(nums);
    }
    public static void mergeSort(int start, int end) {
        if (start<end) {
            int mid = (start+end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p<=mid || q<=end) {
                if (q>end || (p<=mid && nums[p]< nums[q])) {
                    tmp[idx++] = nums[p++];
                } else {
                    tmp[idx++] = nums[q++];
                }
            }

            for (int i=start;i<=end;i++) {
                nums[i]=tmp[i];
            }
        }
    }

    public static void printArray(int[] a) {
        for (int i=0;i<a.length;i++)
            System.out.print(a[i]+"\n");
        System.out.println();
    }
}
