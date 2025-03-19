import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String T = br.readLine();
		String P = br.readLine();

		int[] lps = new int[P.length()];

		int len = 0;  // 현재까지 일치하는 접두사의 길이
		lps[0] = 0;   // 첫번째 문자는 비교 대상이 없으므로 0
		int i = 1;
		while (i < P.length()) {
			if (P.charAt(i) == P.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}

		int count = 0;
		List<Integer> answer = new ArrayList<>();

		int idx = 0;
		for(int j = 0; j < T.length(); j++) {
			while(idx > 0 && T.charAt(j) != P.charAt(idx)) {
				idx = lps[idx -1];
			}

			if(T.charAt(j) == P.charAt(idx)) {
				if(idx == P.length() -1) {
					count++;
					answer.add(j - P.length() + 2);
					idx = lps[idx];
				}else {
					idx++;
				}
			}
		}

		bw.write(String.valueOf(count));
		bw.newLine();
		for (int k = 0; k < answer.size(); k++) {
			bw.write(String.valueOf(answer.get(k)));
			if(k < answer.size() - 1) {
				bw.write(" ");
			}
		}
		bw.flush();
	}
}
