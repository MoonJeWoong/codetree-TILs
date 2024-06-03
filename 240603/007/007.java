import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        Secret secret = new Secret(inputs[0], inputs[1], Integer.parseInt(inputs[2]));
        System.out.println(secret);
    }
}

class Secret {
    String code;
    String location;
    int time;

    public Secret(String code, String location, int time) {
        this.code = code;
        this.location = location;
        this.time = time;
    }

    @Override
    public String toString() {
        return "secret code : " + this.code + "\n"
            + "meeting point : " + this.location + "\n"
            + "time : " + this.time;
    }
}