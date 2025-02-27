import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] ground = new int[N+1];
		int[] sums = new int[N+2];

		for(int i = 1; i <= N; i++) {
			ground[i] = Integer.parseInt(st.nextToken());
		}

		while(M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			sums[a] += k;
			sums[b+1] -= k;
		}

		int change = 0;
		for(int i = 1; i <= N; i++) {
			change += sums[i]; //
			ground[i] += change;
		}

		for(int num=1; num <= N; num++) bw.write(ground[num] + " ");
		bw.flush();
		bw.close();

	}


}
