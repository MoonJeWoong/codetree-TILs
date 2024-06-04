import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Weather> weathers = new ArrayList<>();
        for (int i=0; i<n; i++) {
            String[] inputs = br.readLine().split(" ");
            if (inputs[2].equals("Rain")) {
                weathers.add(new Weather(inputs[0], inputs[1], inputs[2]));
            }
        }

        weathers.sort(Comparator.naturalOrder());

        System.out.println(weathers.get(0));
    }
}

class Weather implements Comparable<Weather> {
    String date;
    String day;
    String weather;

    public Weather(String date, String day, String weather) {
        this.date = date;
        this.day = day;
        this.weather = weather;
    }

    @Override
    public String toString() {
        return date + " " + day + " " + weather;
    }

    @Override
    public int compareTo(Weather other) {
        return this.date.compareTo(other.date);
    }
}