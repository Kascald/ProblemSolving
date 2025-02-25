import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

		StringTokenizer inputs = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(inputs.nextToken());
		int M = Integer.parseInt(inputs.nextToken());

		int[][] matrix = new int[N+1][N+1];
		int[][] prefix = new int[N+1][N+1];   // 1 based 인덱스 편의를 위해

		for(int j= 1; j <= N; j++) {
			inputs = new StringTokenizer(br.readLine(), " ");
			for(int k = 1; k <= N; k++) {
				matrix[j][k] = Integer.parseInt(inputs.nextToken());
			}
		}

		for(int j= 1; j <= N; j++) {
			for(int k = 1; k <= N; k++) {
				prefix[j][k] = matrix[j][k] + prefix[j -1][k] + prefix[j][k -1] - prefix[j -1][k -1];
			}
		}

		for(int k = 0; k < M; k++) {
			inputs = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(inputs.nextToken());
			int y1 = Integer.parseInt(inputs.nextToken());

			int x2 = Integer.parseInt(inputs.nextToken());
			int y2 = Integer.parseInt(inputs.nextToken());

			int sumResult = prefix[x2][y2] - prefix[x1 -1][y2] - prefix[x2][y1 -1] + prefix[x1 -1][y1 -1];
			bw.write(sumResult + "\n");
		}


		bw.flush();
		bw.close();
	}


}
