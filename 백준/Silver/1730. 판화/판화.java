import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				int size = Integer.parseInt(br.readLine());
				String commands = br.readLine();

				char[][] board = new char[size][size];

				// 판 초기화
				for(int i = 0; i < size; i++) {
					for(int j = 0; j < size; j++) {
						board[i][j] = '.';
					}
				}

				int curX = 0, curY =0;

				for(char cmd : commands.toCharArray()) {
					int nextX = curX, nextY = curY;

					//커맨드에 따른 다음 이동 위치 설정
					switch (cmd) {
						case 'U' : nextY--; break;
						case 'D' : nextY++; break;
						case 'L' : nextX--; break;
						case 'R' : nextX++; break;
					}

					// 커서의 다음 이동위치가 판의 범위를 벗어나는지 체크
					if( nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) continue;

					// 현재 위치의 흔적 남기기
					if(cmd == 'U' || cmd == 'D') {
						board[curY][curX] = (board[curY][curX] == '-' || board[curY][curX] == '+') ? '+' : '|';
						board[nextY][nextX] = (board[nextY][nextX] == '-' || board[nextY][nextX] == '+') ? '+' : '|';
					} else {
						board[curY][curX] = (board[curY][curX] == '|' || board[curY][curX] == '+') ? '+' : '-';
						board[nextY][nextX] = (board[nextY][nextX] == '|' || board[nextY][nextX] == '+') ? '+' : '-';
					}

					curX = nextX;
					curY = nextY;
				}

				for(int i = 0 ; i < size ; i++) {
					System.out.println(board[i]);
				}

		}
}