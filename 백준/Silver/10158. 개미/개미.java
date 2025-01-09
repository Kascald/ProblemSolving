import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int W = Integer.parseInt(input[0]); // 너비
		int H = Integer.parseInt(input[1]); // 높이

		String[] position = br.readLine().split(" ");
		int P = Integer.parseInt(position[0]); // 시작 X 좌표
		int Q = Integer.parseInt(position[1]); // 시작 Y 좌표

		int t = Integer.parseInt(br.readLine()); // 시간
        // P+t : 총 이동거리
        // 2W  : 주기
        // x   : 주기 내 남은 거리
        // x > W : 이동 방향에 반전이 필요함
		int x = (P+ t) % (2 * W);
		if( x > W ) x = 2* W - x;

		int y  = (Q + t) % (2 * H);
		if( y > H ) y = 2* H - y;

		System.out.println(x +" "+ y);
	}

}
