import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];


		StringTokenizer stoken = new StringTokenizer(br.readLine());

		int[] checked = new int[1000001];
		for (int i = 0; i < n && stoken.hasMoreTokens(); i++)
			input[i] = Integer.parseInt(stoken.nextToken());
		int x = Integer.parseInt(br.readLine());

		Arrays.sort(input);
		int left = 0 , right = n - 1;
		int cnt = 0 ;

		while (left < right) {
			int sum = input[left] + input[right];
			if (sum == x) {
				cnt++;
				left++;
				right--;
			} else if (sum < x) {
				left++;
			} else {
				right --;
			}
		}


		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
	}


}
