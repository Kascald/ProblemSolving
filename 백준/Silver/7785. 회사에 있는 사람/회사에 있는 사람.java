import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Set<String> employeeSet = new HashSet<>();

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			String name = st.nextToken();
			boolean inOut = st.nextToken().equals("enter"); // true = in , false = out

			if (inOut)  employeeSet.add(name);
			else employeeSet.remove(name);
		}

		List<String> employees = new ArrayList<>(employeeSet);
		employees.sort(Collections.reverseOrder());

		for (String name : employees) {
			bw.write(name + "\n");
		}
		bw.flush();
		bw.close();
	}

}
