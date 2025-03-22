import java.io.*;
import java.util.StringTokenizer;

/*
 *  BaekJoon #1259  :  https://www.acmicpc.net/problem/1259
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		while(true) {
			String s = br.readLine();
			if("0".equals(s)) break;
			
			String result = isPalindrome(s);
			bw.write( result + "\n");
		}
		bw.flush();
	}

	static String isPalindrome(String num) {
		if(num.length() % 2 == 0) {  // 문자열의 길이가 짝수일 때
			int middle = (num.length() / 2) ;
			String leftStr = num.substring(0, middle);
			String rightStr = num.substring(middle);

			StringBuilder stringBuffer =  new StringBuilder(rightStr);
			String reversedRightStr = stringBuffer.reverse().toString();

			if(reversedRightStr.equals(leftStr)) return "yes";
			else return "no";

		} else{ // 문자열의 길이가 홀수일 때
			int middle = (num.length() / 2);

			String leftStr = num.substring(0, middle);
			String rightStr = num.substring(middle+1);

			StringBuilder stringBuffer =  new StringBuilder(rightStr);
			String reversedRightStr = stringBuffer.reverse().toString();

			if(reversedRightStr.equals(leftStr)) return "yes";
			else return "no";
		}
	}
}
