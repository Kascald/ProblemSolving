import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int participants = Integer.parseInt(bf.readLine());
        int staffNumber = Integer.parseInt(bf.readLine());

        int[][] staff = new int[26][14]; // 각 직원의 점수 저장
        boolean[] staffBool = new boolean[26]; // 직원 존재 여부
        List<Integer> allScoresList = new ArrayList<>(); // 전체 점수를 모아두기 위한 리스트

        int cnt = 1;

        while (cnt <= staffNumber) {
            String[] inputs = bf.readLine().split(" ");
            char staffName = inputs[0].charAt(0);
            int votes = Integer.parseInt(inputs[1]);

            if (votes < participants * 0.05) {
                cnt++;
                continue; // 5% 미만 득표는 패스
            }

            int[] scoreGroup = new int[14]; // 개개인 점수
            for (int i = 0; i < 14; i++) {
                scoreGroup[i] = votes / (i + 1);
                allScoresList.add(scoreGroup[i]); // 전체 점수 리스트에 추가
            }
            staff[staffName - 'A'] = scoreGroup;
            staffBool[staffName - 'A'] = true;

            cnt++;
        }

        Collections.sort(allScoresList, Collections.reverseOrder());

        Map<Integer, Integer> scoreToMedalCount = new HashMap<>();
        int medalCount = 1;
        for (int i = 0; i < allScoresList.size(); i++) {
            int score = allScoresList.get(i);
            if (!scoreToMedalCount.containsKey(score)) {
                scoreToMedalCount.put(score, medalCount);
            }
            medalCount++;
        }

        int[] medals = new int[26]; // 각 직원이 받은 메달 개수
        for (int i = 0; i < staff.length; i++) {
            if (staffBool[i]) {
                for (int j = 0; j < staff[i].length; j++) {
                    int score = staff[i][j];
                    if (scoreToMedalCount.containsKey(score)) {
                        medals[i] += scoreToMedalCount.get(score);
                    }
                }
            }
        }

        // 결과 출력
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
