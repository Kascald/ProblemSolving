import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
		public static void main(String[] args) throws IOException {

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String[] input = br.readLine().split(" ");

				int N = Integer.parseInt(input[0]);
				int M = Integer.parseInt(input[1]);

				boolean[] rowGuard = new boolean[N];
				boolean[] colGuard = new boolean[M];

				for(int i = 0; i < N; i++) {
					String stateString = br.readLine();
					for(int j = 0 ;j < M ; j++) {
						if (stateString.charAt(j)=='X') {
							rowGuard[i] = true;
							colGuard[j] = true;
						}
					}
				}

				int rowCount = 0;
				for( boolean hasGuard : rowGuard) {
					if (!hasGuard) rowCount++;
				}
				int colCount = 0;
				for( boolean hasGuard : colGuard) {
					if (!hasGuard) colCount++;
				}

			System.out.println(Math.max(rowCount, colCount));
		}
}
