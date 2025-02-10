import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	/*
	* 문제 요구사항
	*
	* Height x Width 의 호텔이 있고 각 층에 Width 만큼의 방이 있다.
	* 호텔의 왼쪽면에는 엘레베이터가 존재하는데, 이 엘레베이터를 이용한 거리는 무시한다.
	* 이동거리가 짧을수록 좋다.
	* 이동거리가 같다면 낮은층을 선호한다.
	* 즉, 모든 층의 1호부터 방이 배정된다.
	*
	* 입력 H가 10보다 크거나 같다면 방 번호는 YYXX가 된다.
	* 입력 W는 W <= 99 , 1 <= H
	* */
		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int testCase = Integer.parseInt(br.readLine());
				String[] result = new String[testCase];
				int cnt = 0;
				while(testCase-- > 0) {
					String[] inputs = br.readLine().split(" ");
					int H = Integer.parseInt(inputs[0]);
					int W = Integer.parseInt(inputs[1]);
					int N = Integer.parseInt(inputs[2]);

					String roomH;
					String roomW;
					if (N % H > 0) { // N % H가 0보다 큰 경우
						roomW = String.format("%02d", (N / H) + 1); // 방번호는 1 based-indexing
						roomH = String.format("%d", N % H); // 층수 형식화
					} else { // N % H == 0인 경우
						roomW = String.format("%02d", (N / H)); // 방번호는 (N / H)
						roomH = H > 9 ? String.format("%02d", H) : String.format("%d", H); // 층수는 H
					}
					result[cnt] = roomH + roomW;
					cnt++;
				}

				for(String re : result) System.out.println(re);
		}
}
