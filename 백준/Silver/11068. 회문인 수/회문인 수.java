import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		int[] result = new int[testCase];
		int index = 0;

		while (testCase > 0) {
			int number = Integer.parseInt(br.readLine());
			boolean isPalindrome = false;

			for (int i = 2; i <= 64; i++) {
				StringBuilder sb = positionConvert(number, i);
				boolean check = true;

				for (int j = 0; j < sb.length() / 2; j++) {
					if (sb.charAt(j) != sb.charAt(sb.length() - j - 1)) {
						check = false;
						break;
					}
				}

				if (check) {
					isPalindrome = true;
					break;
				}
			}

			if (isPalindrome) {
				result[index++] = 1;
			} else {
				result[index++] = 0;
			}
			testCase--;
		}

		for (int i = 0; i < index; i++) {
			System.out.println(result[i]);
		}
	}

	private static StringBuilder positionConvert(int num, int position) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			int divide = num % position;
			if (divide < 10) sb.append(divide);
			else sb.append((char) (divide - 10 + 'A'));
			num = num / position;
		}
		return sb.reverse();
	}
}