import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // N , M input
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());


		StringTokenizer st2 = new StringTokenizer(br.readLine(), " "); // Array input
		int[] arr = new int[N];
		for(int i = 0; i < N; i ++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}

		int[] sums = new int[N + 1];
		for(int j = 1; j <= N; j++) {
			sums[j] = sums[j - 1] + arr[j - 1];
		}

		int[] result = new int[M];

		for(int i =0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine(), " "); // N , M input
			int start = Integer.parseInt(st3.nextToken());
			int end = Integer.parseInt(st3.nextToken());

			result[i] = sums[end] - sums[start - 1];
		}

		for(int n : result) bw.write(n+ "\n");

		bw.flush();
		bw.close();
	}


}
