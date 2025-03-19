import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		int aScore = 0;
		int dScore = 0;
		int mScore = 0;

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < arr.length - 1; i++) {
			int i1 = arr[i] - arr[i + 1];
			if (i1 == 1)  dScore++;
			else if (i1 == -1) aScore ++;
			else mScore ++;
		}


		String result = "";
		if (aScore == 7) result = "ascending\n";
		if (dScore == 7) result = "descending\n";
		if (mScore != 0) result = "mixed\n";

		bw.write(result);
		bw.flush();

	}


}
