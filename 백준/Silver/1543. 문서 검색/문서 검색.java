import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> compare = new ArrayList<>();
		compare.add(br.readLine());
		compare.add(br.readLine());
		int count = 0;
		String calc = compare.get(0);

		while (calc.length() >= compare.get(1).length()) {

			if (calc.startsWith(compare.get(1))) {
				calc = calc.substring(compare.get(1).length());
				count++;
				continue;
			}else {
				calc = calc.substring(1);
				continue;
			}

		}

		System.out.println(count);
	}
}
