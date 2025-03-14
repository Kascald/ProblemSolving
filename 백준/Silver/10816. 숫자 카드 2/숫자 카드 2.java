import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] cards = new int[N];

		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards);

		int M = Integer.parseInt(br.readLine());
		int[] counts = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			if (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				counts[i] = findBiggerThan(cards, num) - firstFindIndex(cards, num);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			if (i == M - 1) sb.append(counts[i]);
			else {
				sb.append(counts[i]).append(" ");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static int firstFindIndex(int[] arr, int target) {
		int left = 0, right = arr.length;
		while (left < right) {
			int middle = (left + right) / 2;
			if (arr[middle] >= target) {
				right = middle;
			} else {
				left = middle + 1;
			}
		}
		return left;
	}

	static int findBiggerThan(int[] arr, int target) {
		int left = 0, right = arr.length;
		while (left < right) {
			int middle = (left + right) / 2;
			if (arr[middle] > target) {
				right = middle;
			} else {
				left = middle + 1;
			}
		}
		return left;
	}
}
