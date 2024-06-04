import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        Product product1 = new Product();
        Product product2 = new Product(inputs[0], Integer.parseInt(inputs[1]));

        System.out.println(product1);
        System.out.println(product2);
    }
}

class Product {
    String title;
    int code;

    public Product() {
        this.title = "codetree";
        this.code = 50;
    }

    public Product(String title, int code) {
        this.title = title;
        this.code = code;
    }

    @Override
    public String toString() {
        return "product " + this.code + " is " + this.title;
    }
}