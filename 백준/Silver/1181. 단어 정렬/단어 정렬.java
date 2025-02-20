import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<String> dict = new ArrayList<>();
		while (N-- > 0) {
			dict.add(br.readLine());
		}

		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) return o1.compareTo(o2);
				return o1.length() - o2.length();
			}
		};

		dict.sort(comp);

		Set<String> result = new LinkedHashSet<>(dict);

		for (String r : result) bw.write(r + "\n");

		bw.flush();
		bw.close();
	}
}
