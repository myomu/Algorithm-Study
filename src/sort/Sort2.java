package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 성적이 낮은 순서로 학생 출력하기
 * 180p
 */
public class Sort2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int score = Integer.parseInt(input[1]);
            Student student = new Student(name, score);
            list.add(student);
        }

        list.sort((o1, o2) -> o1.getScore() < o2.getScore() ? -1 : (o1.getScore() == o2.getScore()) ? 0 : -1);

        for (Student student : list) {
            System.out.print(student.getName() + " ");
        }

    }

    private static class Student {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
