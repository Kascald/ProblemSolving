import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] sessions = new int[N][2];
		List<int[]> result = new ArrayList<>();

		for(int i = 0; i < N ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sessions[i][0] = start;
			sessions[i][1] = end;
		}

		Arrays.sort(sessions, (s1, s2) ->
				s1[1] != s2[1] ? Integer.compare(s1[1], s2[1]) : Integer.compare(s1[0] , s2[0]));

		int count =0;
		int lastEndTime = 0;
		for (int[] session : sessions) {
			if(session[0] >= lastEndTime) { // 마지막 종료시간보다 이번에 비교하는 세션의 시작시간이 같거나 크면
				count++;
				lastEndTime = session[1]; // session 의 끝나는 시간으로 업데이트
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
	}
}
