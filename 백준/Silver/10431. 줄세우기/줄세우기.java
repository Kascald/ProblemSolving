import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();

		while (P-- > 0) {
			int T = sc.nextInt();
			int[] input = new int[20];
			int moveCount = 0;

			for (int i = 0; i < 20; i++) input[i] = sc.nextInt();


			for (int i = 0; i < 20; i++) { // 맨앞 학생부터 자신보다 큰 학생 탐색
				int pointer = input[i];
				int j = i - 1 ; // 포인터 값 앞 자리

				while (j >= 0 && input[j] > pointer) {
					input[j + 1] = input[j]; //뒤로 한칸씩 이동 (덮어쓰기 방지로 뒤부터 앞으로 체크)
					j--;
					moveCount++;
				}
				input[j + 1] = pointer;
			}
			System.out.println(T +" "+moveCount);
		}

	}
    
}