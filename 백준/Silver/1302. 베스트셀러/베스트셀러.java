import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> books = new HashMap<>();

		while (N-- > 0) {
			String bookTitle = br.readLine();
			books.put(bookTitle, books.getOrDefault(bookTitle, 0) + 1);
		}


		String bestSeller = Collections.min(books.entrySet(), (a, b) -> {
			if (!a.getValue().equals(b.getValue())) {
				return b.getValue() - a.getValue();
			}

			return a.getKey().compareTo(b.getKey());
		}).getKey();


		bw.write(bestSeller);
		bw.flush();
		bw.close();


	}


}
