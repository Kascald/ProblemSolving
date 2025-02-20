import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


				int input = Integer.parseInt(br.readLine());
				List<Member> members = new ArrayList<>();
				int index = 0;

				for(int i =0; i < input; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine(), " ");
					members.add( new Member(st.nextToken(), st.nextToken(), i));
				}

				Comparator<Member> comp = new Comparator<>() {
					@Override
					public int compare(Member o1, Member o2) {
						if (o1.age != o2.age) return o1.age - o2.age;
						return o1.joinIdx - o2.joinIdx;
					}
				};

				members.sort(comp);


				for(Member m : members) {
					bw.write(m.age + " " + m.name+"\n");
				}

				bw.flush();
				bw.close();

		}

	static class Member {
			int age;
			String name;
			int joinIdx;

			public Member(String age, String name, int joinIdx) {
				this.age = Integer.parseInt(age);
				this.name = name;
				this.joinIdx = joinIdx;
			}
	}

}


