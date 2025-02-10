import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int boardSize = Integer.parseInt(br.readLine());
		char[][] arrange = new char[boardSize][boardSize];

		for (int y = 0; y < boardSize; y++) {
			String input = br.readLine();
			arrange[y] = input.toCharArray();
		}

		int maximumLength = getMaxCandies(arrange, boardSize); // 초기 최대 길이 계산

		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				// 가로 방향 스왑
				if (x + 1 < boardSize && arrange[y][x] != arrange[y][x + 1]) {
					swap(arrange, x, y, x + 1, y);
					maximumLength = Math.max(maximumLength, getMaxCandies(arrange, boardSize));
					swap(arrange, x, y, x + 1, y);
				}

				// 세로 방향 스왑
				if (y + 1 < boardSize && arrange[y][x] != arrange[y + 1][x]) {
					swap(arrange, x, y, x, y + 1);
					maximumLength = Math.max(maximumLength, getMaxCandies(arrange, boardSize));
					swap(arrange, x, y, x, y + 1);
				}
			}
		}

		System.out.println(maximumLength);
	}

	private static void swap(char[][] arrange, int x1, int y1, int x2, int y2) {
		char temp = arrange[y1][x1];
		arrange[y1][x1] = arrange[y2][x2];
		arrange[y2][x2] = temp;
	}

	// 전체 보드에서 최대 연속 사탕 길이 계산
	private static int getMaxCandies(char[][] arrange, int boardSize) {
		int maxLength = 1;

		// 행 검사
		for (int y = 0; y < boardSize; y++) {
			int count = 1;
			for (int x = 1; x < boardSize; x++) {
				if (arrange[y][x] == arrange[y][x - 1]) {
					count++;
					maxLength = Math.max(maxLength, count);
				} else {
					count = 1;
				}
			}
		}

		// 열 검사
		for (int x = 0; x < boardSize; x++) {
			int count = 1;
			for (int y = 1; y < boardSize; y++) {
				if (arrange[y][x] == arrange[y - 1][x]) {
					count++;
					maxLength = Math.max(maxLength, count);
				} else {
					count = 1;
				}
			}
		}

		return maxLength;
	}

}
