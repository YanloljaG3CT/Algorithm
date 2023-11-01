import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static Person[] persons;

    static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        persons = new Person[N];
        for (int i = 0; i < N; i++) {
            int age = sr.nextInt();
            String name = sr.next();
            persons[i] = new Person(age, name);
        }
    }

    static void solution() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(persons);
        for (Person person : persons) {
            sb.append(person.age).append(" ").append(person.name).append('\n');
        }
        System.out.println(sb);
    }

    static class Person implements Comparable<Person> {

        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return age - o.age;
        }
    }


    static class ScannerReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
