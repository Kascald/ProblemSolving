import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//BAEKJOON #2470
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

		int N = Integer.parseInt(br.readLine());
		int[] fluids = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			fluids[i] = Integer.parseInt(st.nextToken());
		}


		int[] re = isCloserZero(fluids);

		bw.write(fluids[re[0]] +" " + fluids[re[1]]+"\n");
		bw.flush();
	}

	static int[] isCloserZero(int[] arr) {
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1;
		int[] result = new int[2];
		int minDiff = Integer.MAX_VALUE;

		while (left < right) {
			int sum = arr[left] + arr[right];
			int absSum = Math.abs(sum);

			if (absSum < minDiff) {
				minDiff = absSum;
				result[0] = left;
				result[1] = right;
			}

			if (sum < 0) {
				left++;
			} else if (sum > 0) {
				right--;
			} else {
				return result;
			}
		}
		return result;
	}
}
