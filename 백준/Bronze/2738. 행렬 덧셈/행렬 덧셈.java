import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputSize = br.readLine().split(" ");
		int x = Integer.parseInt(inputSize[0]);
		int y = Integer.parseInt(inputSize[1]);
		int[][] a = new int[x][y];
		int[][] b = new int[x][y];

		matrixInput(br, x, y, a);
		matrixInput(br, x, y, b);

		int[][] result = matrixSum(x, y, a, b);

		for (int[] row : result) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	private static void matrixInput(BufferedReader br, int x, int y, int[][] b) throws IOException {
		for (int i = 0; i < x; i++) {
			String[] bInput = br.readLine().split(" ");

			for (int j = 0; j < y; j++) {
				b[i][j] = Integer.parseInt(bInput[j]);
			}
		}
	
	}

	private static int[][] matrixSum(int x, int y, int[][] a, int[][] b) {
		int[][] result = new int[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		return result;
	}
}
