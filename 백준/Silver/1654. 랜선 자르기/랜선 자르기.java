import java.io.*;
import java.util.StringTokenizer;

/*
 *  BaekJoon #1654  :  https://www.acmicpc.net/problem/1654
 * */
public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선
		long N = Long.parseLong(st.nextToken()); // 필요한 랜선 개수

		long[] cables = new long[K];
		for (int i = 0; i < K; i++) {
			cables[i] = Long.parseLong(br.readLine());
		}

		bw.write((String.valueOf(maximumCutLength(cables, N))));
		bw.flush();

	}

	static long cableCutting(long[] cables , long cutLength) {
		long cnt = 0;
		for(long len : cables) {  // 가지고 있는 케이블들 중에서
			cnt += len / cutLength;  // 원하는 길이로 자른 결과 나오는 개수 카운트
		}
		return cnt;
	}

	static long maximumCutLength(long[] cables, long wannaCount) {
		long left = 0;
		long right = (1L << 31); // 랜선의 길이는 2^31-1보다 작거나 같은 자연수이다.
		long answer = -1;

		while ( left <= right ) {
			long mid = (left + right) / 2;

			if(cableCutting(cables, mid) >= wannaCount) { // mid 값을 기준으로 케이블 커팅 시 원하는 랜선 개수 N보다 큰지 확인
				left = mid + 1;
				answer = mid;  // answer 업데이트
			}else {
				right = mid - 1;
			}
		}

		return answer;
	}

}
