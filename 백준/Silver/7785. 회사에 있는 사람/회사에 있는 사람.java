import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		TreeSet<String> employeeSet = new TreeSet<>(Collections.reverseOrder());

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			boolean inOut = st.nextToken().equals("enter");

			if (inOut) employeeSet.add(name);
			else employeeSet.remove(name);
		}

		for (String name : employeeSet) {
			bw.write(name + "\n");
		}
		bw.flush();
		bw.close();
	}

}
