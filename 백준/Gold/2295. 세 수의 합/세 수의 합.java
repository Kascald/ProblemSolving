import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		//입력
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] sums = new int[(N * (N - 1)) / 2];
		int sIndex = 0;

		for (int i = 0; i < N; i++)
			for (int j = i; j < N; j++)
				sums[sIndex++] = arr[i] + arr[j];

		//정렬
		Arrays.sort(sums);

		int answer = -1;
		for(int i =0; i < N; i++) {
			for (int j =0; j <N ;j++){
				int target = arr[i] - arr[j];
				if(isOptimal(sums , target))
					answer = Math.max(answer, arr[i]);
			}
		}


		bw.write(String.valueOf(answer));
		bw.flush();
	}

	static boolean isOptimal(int[] arr , int target) {
		int left = 0, right =  arr.length -1;
		while(left <= right) {
			int middle = (left + right) / 2;
			if(arr[middle] < target) left = middle + 1;
			else if(arr[middle] > target) right = middle -1;
			else return true;
		}
		return false;
	}

}
