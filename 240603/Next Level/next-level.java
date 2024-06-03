import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        User user1 = new User();
        User user2 = new User(inputs[0], Integer.parseInt(inputs[1]));
        System.out.println(user1);
        System.out.println(user2);
    }
}

class User {
    String id;
    int level;

    public User() {
        this.id = "codetree";
        this.level = 10;
    }

    public User(String id, int level) {
        this.id = id;
        this.level = level;
    }

    @Override
    public String toString() {
        return "user " + this.id + " lv " + this.level;
    }
}