import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int num = Integer.parseInt(input[0]);
		int position = Integer.parseInt(input[1]);

		StringBuilder sb = new StringBuilder();

		while(num > 0) {
			int divide = num % position;
			if (divide < 10) sb.append(divide);
			else sb.append((char)(divide - 10 + 'A'));
			num = num / position;
		}

		System.out.println(sb.reverse());
	}
}
