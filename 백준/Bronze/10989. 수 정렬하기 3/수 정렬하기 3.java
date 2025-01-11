import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] number = new int[10001];
		for(int i = 0 ; i < N ; i ++)
			number[Integer.parseInt(br.readLine())]++; // 자연수 등장 횟수에 대한 카운트 배열에 증가


		for(int i = 1; i <=10000; i++)
			while(number[i]-- > 0) {
				bw.write(i +"\n");  //카운트를 줄여가면서 오름차순으로 출력
			}
		bw.flush();
		bw.close();
	}
}