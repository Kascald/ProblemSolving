import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


	public static int[] eurekaNumber(int num) {
		int[] triangle = new int[num];
		int index = 0;

		for (int i = 1; ; i++) {
			int triSum = i * (i + 1) / 2;
			if (triSum >= num) break;

			triangle[index++] = triSum;
//			System.out.printf("tri[] input %d \n", triSum);
		}

		return Arrays.copyOf(triangle, index);
	}

	public static int sumCheck(int[] triNum, int number) {
		for (int i = 0; i < triNum.length; i++) {
			for (int j = 0; j < triNum.length; j++) {
				for (int k = 0; k < triNum.length; k++) {
					int sum = triNum[i] + triNum[j] + triNum[k];
//					System.out.printf("sumCheck = %d \n", sum);
					if(sum == number) return 1;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int testCase = Integer.parseInt(br.readLine());

		int[] input = new int[testCase];
		int[] answer = new int[testCase];
		for (int i = 0; i < testCase; i++) {

			input[i] = Integer.parseInt(br.readLine());
			int[] eurekaThanSmall = eurekaNumber(input[i]);

			answer[i] = sumCheck(eurekaThanSmall , input[i]);
		}

		for (int val : answer) System.out.println(val);

	}
}
