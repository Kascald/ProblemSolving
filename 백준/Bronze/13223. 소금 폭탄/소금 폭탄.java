import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

//13223 https://www.acmicpc.net/problem/13223
/*
* 첫째 줄에는 현재 시각이 hh:mm:ss로 주어진다. 시간의 경우 0≤h≤23 이며, 분과 초는 각각 0≤m≤59, 0≤s≤59 이다.

두 번째 줄에는 소금 투하의 시간이 hh:mm:ss로 주어진다.
* */
public class Main {
	public static void main(String[] args) throws IOException, ParseException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputNow = br.readLine();
		String bombDown = br.readLine();

		String[] input = inputNow.split(":");
		String[] down = bombDown.split(":");

		int currentHour = Integer.parseInt(input[0]);
		int currentMin = Integer.parseInt(input[1]);
		int currentSec = Integer.parseInt(input[2]);

		int downHour = Integer.parseInt(down[0]);
		int downMin = Integer.parseInt(down[1]);
		int downSec = Integer.parseInt(down[2]);

		int currentSecSum = currentHour *3600 + currentMin*60 + currentSec;
		int downSecSum = downHour *3600 + downMin*60 + downSec;

		int resultSecSum = downSecSum - currentSecSum;
		if(resultSecSum <= 0) resultSecSum += 24*3600;

		int diffHour = resultSecSum / 3600;
		int diffMin = (resultSecSum %3600) / 60;
		int diffSec = resultSecSum %60;

		System.out.printf("%02d:%02d:%02d%n", diffHour , diffMin , diffSec);
	}
}
