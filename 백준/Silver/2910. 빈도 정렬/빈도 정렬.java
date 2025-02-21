import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // length
		int C = Integer.parseInt(st.nextToken()); // limit

		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		Map<Integer, Integer> freqMap = new HashMap<>();
		Map<Integer, Integer> indexMap = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st2.nextToken());
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1); // frequency count
			indexMap.putIfAbsent(num, i); // index
		}

		List<Map.Entry<Integer, Integer>> sortList = new ArrayList<>(freqMap.entrySet());

		sortList.sort((a, b) -> {
			int freqCompare = Integer.compare(b.getValue(), a.getValue());
			if (freqCompare == 0) return Integer.compare(indexMap.get(a.getKey()), indexMap.get(b.getKey()));
			return freqCompare;
		});


		for (Map.Entry<Integer, Integer> entry : sortList) {
			int num = entry.getKey();
			int freq = entry.getValue();
			for (int j = 0; j < freq; j++) {
				bw.write(num + " ");
			}
		}
		bw.flush();

	}
}
