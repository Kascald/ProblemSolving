import java.io.*;

public class Main {
		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


				int T = Integer.parseInt(br.readLine());

				while (T-- > 0) {
					int score = 0;
					int count = 0;
					String s = br.readLine();
					for (int i = 0; i < s.length(); i++) {
						if (s.charAt(i) == 'O') {
							count++;
							score += count;
						} else {
							count = 0;
						}
					}

					bw.write(score + "\n");
				}

				bw.flush();
		}
}
