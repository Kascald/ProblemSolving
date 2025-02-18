import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int participants = Integer.parseInt(bf.readLine());
		int staffNumber = Integer.parseInt(bf.readLine());

		int[][] staff = new int[26][14];
		boolean[] staffBool = new boolean[26];
		int[] staffAllScore = new int[26 * 14];
		int cnt = 1;

		while (cnt <= staffNumber) {
			String[] inputs = bf.readLine().split(" ");
			char staffName = inputs[0].charAt(0);
			int votes = Integer.parseInt(inputs[1]);

			if (votes < participants * 0.05) {
				cnt++;
				continue; // 전체 5%미만 득표 패스
			}

			int[] scoreGroup = new int[14]; //개개인 점수
			int staffIndex = (staffName - 'A') * 14; // 해당 staff 의 점수 시작 위치
			for (int i = 0; i < 14; i++) {
				scoreGroup[i] = votes / (i + 1);
				staffAllScore[staffIndex + i] = votes / (i + 1); // staffAllScore 에 올바른 위치에 저장
			}
			staff[staffName - 'A'] = scoreGroup; // 개개인 점수 저장



			staff[staffName - 'A'] = scoreGroup; // 점수집합
			staffBool[staffName - 'A'] = true;

			cnt++;
		}

		Integer[] staffAllScoreObj = Arrays.stream(staffAllScore).boxed().toArray(Integer[]::new);
		Arrays.sort(staffAllScoreObj, Collections.reverseOrder());
		staffAllScore = Arrays.stream(staffAllScoreObj).mapToInt(Integer::intValue).toArray();

		int[] medals = new int[26];
		int medalsCnt = 14;
		int startIdx = 0;
		int[] compare = new int[14];
		Arrays.fill(compare, 0);

		while(startIdx < medalsCnt) { // staff 모든점수 중 14번째 큰수까지만 순회
			int max = staffAllScore[startIdx];
			for(int j = 0; j < staff.length; j++) {
				if (Arrays.equals(staff[j], compare) || staff[j].length == 0) continue; // 빈 배열 또는 null이면 스킵

				for (int k = 0; k < staff[j].length; k++) {
					if (staff[j][k] == max) {
						medals[j]++;
					}
				}
			}
			startIdx++;
		}


		for (int i = 0; i < medals.length; i++) {
			if (staffBool[i]) {
				char staffAlp = (char) ('A' + i);
				bw.write(staffAlp + " " + medals[i] + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
