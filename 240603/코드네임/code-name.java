import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<User> users = new ArrayList<>();
        for (int i=0; i<5; i++) {
            String[] inputs = br.readLine().split(" ");
            users.add(new User(inputs[0], Integer.parseInt(inputs[1])));
        }
        users.sort(Comparator.naturalOrder());
        System.out.println(users.get(0));
    }
}

class User implements Comparable<User> {
    String name;
    int score;

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(User other) {
        return this.score - other.score;
    }

    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
}