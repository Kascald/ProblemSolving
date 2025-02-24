import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		Integer[] arrBox = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
		int[] sums = new int[N+1];

		for (int i = 1; i <= N ; i ++) {
			sums[0] = 0;
			sums[i] = sums[i-1] ^ arrBox[i-1];
		}

		int result = 0;
		while(Q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int startQ = Integer.parseInt(st.nextToken());
			int endQ = Integer.parseInt(st.nextToken());

			result ^= (sums[endQ] ^ sums[startQ - 1]);
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
