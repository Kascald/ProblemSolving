import java.io.*;
import java.util.StringTokenizer;

/*
 *  BaekJoon #2805  :  https://www.acmicpc.net/problem/2805
 * */

public class Main {
	static boolean cutTree(int[] treeHeight , int cutH , int M) {
		long sum = 0;
		for(int h : treeHeight) {
			if (h > cutH) sum += h - cutH;
		}
		return sum >= M;
	}

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] trees = new int[N];

		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		int l = 0, r= 1000000000 , ans = -1;
		while(l <= r) {
			int m  = (l + r) / 2;
			if(cutTree(trees, m,M)){
				ans = m;
				l = m + 1;
			}
			else r = m-1;
		}
		bw.write(String.valueOf(ans));
		bw.flush();
	}
	
	
}
