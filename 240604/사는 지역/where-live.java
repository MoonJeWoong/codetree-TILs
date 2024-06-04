import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();
        for (int i=0; i<n; i++) {
            String[] inputs = br.readLine().split(" ");
            people.add(new Person(inputs[0], inputs[1], inputs[2]));
        }

        people.sort(Comparator.reverseOrder());

        System.out.println(people.get(0));
    }
}

class Person implements Comparable<Person> {
    String firstName;
    String address;
    String city;

    public Person(String firstName, String address, String city) {
        this.firstName = firstName;
        this.address = address;
        this.city = city;
    }

    @Override
    public String toString() {
        return "name " + this.firstName + "\n"
            + "addr " + this.address +"\n"
            + "city " +this.city;
    }

    @Override
    public int compareTo(Person other) {
        return this.firstName.compareTo(other.firstName);
    }
}