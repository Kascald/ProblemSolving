import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 *  BaekJoon #2798  :  https://www.acmicpc.net/problem/2798
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());  // N개의 card
		int M = Integer.parseInt(st.nextToken());  // 가깝게 만들어야 할 3개의 카드 숫자 합:  M

		st = new StringTokenizer(br.readLine(), " ");
		Integer[] cards = new Integer[N];

		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards, Collections.reverseOrder());


		int closer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int card1 = cards[i];

			for (int k = i+1; k < N; k++) {
				int card2 = cards[k];

				for (int j = k+1; j < N; j++) {
					int card3 = cards[j];
					int sum = card1 + card2 + card3;
					if (sum <= M) {
						closer = Math.max(closer, sum);
					}
				}
			}
		}

		bw.write(closer + "");
		bw.flush();
	}
}
