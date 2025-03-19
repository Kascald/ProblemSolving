import java.io.*;

public class Main {

	static long[][] unit = {{1, 1}, {1, 0}};
	static long MOD = 1000000007L;

	static long[][] power(long[][] matrix, long N) {

		if(N == 1 || N == 0) {
			return matrix;
		}

		long[][] result = power(matrix , N / 2);

		result = multi(result, result);

		if(N % 2 == 1L) {
		 result = multi(result,unit);
		}

		return result;
	}

	static long[][] multi(long[][] a, long[][] b) {
		long[][] result = new long[2][2];
		result[0][0] = ((a[0][0] * b[0][0]) + (a[0][1] * b[1][0])) % MOD;
		result[0][1] = ((a[0][0] * b[0][1]) + (a[0][1] * b[1][1])) % MOD;
		result[1][0] = ((a[1][0] * b[0][0]) + (a[1][1] * b[1][0])) % MOD;
		result[1][1] = ((a[1][0] * b[0][1]) + (a[1][1] * b[1][1])) % MOD;

		return result;
	}

	static long fibonacci(long N) {

		long[][] result = power(unit, N - 1);

		return result[0][0];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long N = Long.parseLong(br.readLine());
		long answer = fibonacci(N);

		bw.write(String.valueOf(answer));
		bw.flush();
	}
}
