import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		while (true) {
			String s = br.readLine();
			if ("0 0 0".equals(s)) break;

			int[] sides = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(sides);

			if ((sides[0] * sides[0]) + (sides[1] * sides[1]) == (sides[2] * sides[2])) bw.write("right\n");
			else bw.write("wrong\n");
		}
		bw.flush();
	}

}
