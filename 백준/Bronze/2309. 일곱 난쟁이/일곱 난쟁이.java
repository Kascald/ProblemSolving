import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarves = new int[9];

		for (int i = 0; i < 9; i++) {
			dwarves[i] = Integer.parseInt(br.readLine());
		}
		int overSum = Arrays.stream(dwarves).sum() - 100;

		int pointer1 = 0 ;
		int pointer2 = 8;

		Arrays.sort(dwarves);

		while (pointer1 < pointer2) {
			int checkSum = dwarves[pointer1] + dwarves[pointer2];
			if( checkSum == overSum) {
				dwarves[pointer1] = 0;
				dwarves[pointer2] = 0;
				break;
			} else if (checkSum < overSum) {
				pointer1++;
			}else {
				pointer2--;
			}
		}



		for (int height : dwarves) {
			if (height != 0) System.out.println(height);
		}


	}
}
