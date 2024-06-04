import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        Bomb bomb = new Bomb(inputs[0], inputs[1], Integer.parseInt(inputs[2]));
        System.out.println(bomb);
    }
}

class Bomb {
    String code;
    String color;
    int seconds;

    public Bomb(String code, String color, int seconds) {
        this.code = code;
        this.color = color;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "code : " + this.code + "\n"
            "color : " + this.color + "\n"
            "second : " + this.seconds;
    }
}