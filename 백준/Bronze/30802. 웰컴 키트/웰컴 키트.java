import java.io.*;
import java.util.StringTokenizer;

/*
 *  BaekJoon #30802  :  https://www.acmicpc.net/problem/30802
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] demands = new int[6];
		for (int i = 0; i < demands.length; i++) {
			demands[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int ballpenBundle = N / P;
		int ballpenUnit = N % P;

		int tBundle = 0;
		for (int d : demands) {        
			tBundle += bundleCount(d, T);
		}

		bw.write(String.valueOf(tBundle));
		bw.newLine();
		bw.write(ballpenBundle + " " + ballpenUnit);
		bw.flush();
	}


	static int bundleCount(int wanna, int bundle) {
		int count = 0;
		if (wanna == 0) return 0;
		if (wanna % bundle > 0) { // 9 % 5  =  3    > 5 ?  n
			count += (wanna / bundle) + 1;
		} else if(wanna % bundle == 0) {
			count += (wanna / bundle);
		} else count++;
		return count;
	}
}


