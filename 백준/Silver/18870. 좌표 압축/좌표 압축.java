import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int input = Integer.parseInt(br.readLine());
		int[] vertical = new int[input];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < input; i++) {
			vertical[i] = Integer.parseInt(st.nextToken());
		}

		TreeSet<Integer> zipper = Arrays.stream(vertical)
				.boxed()
				.collect(Collectors.toCollection(TreeSet::new));

		int idx = 0;
		Map<Integer, Integer> compressTable = new HashMap<>();
		for (int val : zipper) {
			compressTable.put(val, idx++);
		}

		StringBuilder sb = new StringBuilder();
		for(int num : vertical) {
			sb.append(compressTable.get(num)).append(" ");
		}

		sb.setLength(sb.length() - 1);


		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}


}
