import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputs = br.readLine().split(" ");
		int wheelSize = Integer.parseInt(inputs[0]);
		int rollTIme = Integer.parseInt(inputs[1]);

		char[] wheel = new char[wheelSize];
		Arrays.fill(wheel,'?');

		boolean[] usedCheck = new boolean[26];  //alphabet check

		int pointer = 0;

		while (rollTIme-- > 0) {
			String[] inputs2 = br.readLine().split(" ");
			int turns = Integer.parseInt(inputs2[0]);
			char alphabet = inputs2[1].charAt(0);

			pointer = (pointer + turns) % wheelSize;

			if (wheel[pointer] != '?' && wheel[pointer] != alphabet) {
				bw.write("!\n");
				bw.flush();
				return;
			}

			if (wheel[pointer] == '?' && usedCheck[alphabet - 'A']) {
				bw.write("!\n");
				bw.flush();
				return;
			}

			wheel[pointer] = alphabet;
			usedCheck[alphabet - 'A'] = true;
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < wheelSize; i++) {
			sb.append(wheel[(pointer - i + wheelSize) % wheelSize]);
		}

		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
	}
}
