import java.io.*;
import java.util.*;

/*
 *  BaekJoon 7453  :  https://www.acmicpc.net/problem/7453
 * */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		int idx = 0;
		int[] AB = new int[N * N];
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AB[idx++] = A[i] + B[j];
			}
		}

		Arrays.sort(AB);

		long count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cdSums = C[i] + D[j];
				int lower = firstFindIndex(AB , -cdSums);
				int upper = lastFindIndex(AB , -cdSums);

				count += (upper - lower);
			}
		}


		bw.write(String.valueOf(count));
		bw.flush();

	}


	static int firstFindIndex(int[] pairs, int searchValue) {
		int left = 0 , right = pairs.length;
		while(left < right) {
			int mid = left + (right - left) /2;
			if (pairs[mid] < searchValue) left = mid + 1;
			else right = mid;
		}
		return left;
	}
	static int lastFindIndex(int[]  pairs, int searchValue) {
		int left = 0 , right = pairs.length;
		while(left < right) {
			int mid = left + (right - left) /2;
			if (pairs[mid] <= searchValue) left = mid + 1;
			else right = mid;
		}
		return left;
	}
}
